package com.example.myapplication.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.ItemContactAdapter
import com.example.myapplication.model.ContactModel


class ContactFragment : Fragment() {

    companion object {
        private const val HAS_PHONE = "1"
        private const val CONTACT_LIKE = "contactLike"
    }

    private lateinit var rcvContact: RecyclerView
    private lateinit var adapterContact: ItemContactAdapter

    private val listContact = arrayListOf<ContactModel>()

    private var sharePref: SharedPreferences? = null

    private var resultReadContact =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) getAllContact()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initListener()
        initRecyclerView()
        checkPermission()
    }

    private fun checkPermission() {
        //get SharedPreferences
        sharePref = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val permissionCheck = ContextCompat.checkSelfPermission(
            requireActivity(),
            Manifest.permission.READ_CONTACTS
        )
        when (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            true -> getAllContact()
            else -> {
                resultReadContact.launch(Manifest.permission.READ_CONTACTS)
            }
        }

        //Internal storage -> app
        //
        //        //External storage -> system
    }

    private fun initView(view: View) {
        rcvContact = view.findViewById(R.id.frgContact_rcvContact)
    }

    private fun initListener() {}

    private fun initRecyclerView() {
        adapterContact = ItemContactAdapter(listContact) {
            updateStatusContact(it)
        }
        rcvContact.adapter = adapterContact
        rcvContact.layoutManager = LinearLayoutManager(requireActivity())
    }

    @SuppressLint("Range")
    private fun getAllContact() {
        val cr = requireActivity().contentResolver
        cr?.let {
            val query =
                cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
            query?.let {
                if (it.count > 0) {
                    while (it.moveToNext()) {
                        val model = ContactModel()
                        model.name =
                            it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))

                        val photo =
                            it.getString(it.getColumnIndex(ContactsContract.Contacts.PHOTO_URI))
                        photo?.let { pt -> model.image = pt }

                        val hasPhone =
                            it.getString(it.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

                        val id = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
                        model.idPhoto = id

                        if (hasPhone == HAS_PHONE) readPhoneNumber(model, id)

                        listContact.add(model)
                    }
                    loadContactLike()
                    adapterContact.notifyItemRangeInserted(0, listContact.size - 1)
                }
            }
        }
    }

    @SuppressLint("Range")
    private fun readPhoneNumber(model: ContactModel, id: String) {
        val cr = requireActivity().contentResolver
        cr?.let {
            val query = cr.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                arrayOf(id),
                null
            )
            query?.let {
                if (it.count > 0) {
                    while (it.moveToNext()) {
                        val phone =
                            it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        model.phone = phone
                    }
                }
            }
        }
    }

    private fun updateStatusContact(index: Int) {
        val itemSelected = listContact[index]
        itemSelected.statusLike = !itemSelected.statusLike
        adapterContact.notifyItemChanged(index)
        saveContactLike()
    }

    private fun saveContactLike() {
        sharePref?.let {
            val listSelected =
                listContact.filter { item -> item.statusLike }.map { item -> item.idPhoto }.toList()
            val result = listSelected.joinToString(",") //[1,3,4] => 1,3,4
            with(it.edit()) {
//                putInt()
//                putBoolean()
//                putFloat()
//                putLong()
                putString(CONTACT_LIKE, result)
                apply()
            }
        }
    }

    private fun loadContactLike() {
        sharePref?.let { pref ->
            val listStringId = pref.getString(CONTACT_LIKE, "")  //1,3,4
            val listContactSelected = listStringId?.split(",") //[1,3,4]
            listContactSelected?.forEach { id ->
                listContact.firstOrNull { it.idPhoto == id }?.let {
                    it.statusLike = true
                }
            }
        }
    }

}