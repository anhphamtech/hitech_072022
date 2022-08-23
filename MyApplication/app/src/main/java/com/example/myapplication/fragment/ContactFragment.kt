package com.example.myapplication.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
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
    }

    private lateinit var rcvContact: RecyclerView
    private lateinit var adapterContact: ItemContactAdapter

    private val listContact = arrayListOf<ContactModel>()

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
    }

    private fun initView(view: View) {
        rcvContact = view.findViewById(R.id.frgContact_rcvContact)
    }

    private fun initListener() {}

    private fun initRecyclerView() {
        adapterContact = ItemContactAdapter(listContact) {
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
//                        val photo =
//                            it.getString(it.getColumnIndex(ContactsContract.Contacts.PHOTO_URI))
//                        photo?.let { pt ->
//                            model.image = pt
////                            model.image = getRealPathFromURI(Uri.parse(pt)) ?: ""
//                        }
                        val hasPhone =
                            it.getString(it.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                        if (hasPhone == HAS_PHONE) {
                            val id = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
                            readPhoneNumber(model, id)
                        }

                        listContact.add(model)
                    }
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

    fun getRealPathFromURI(contentUri: Uri): String? {
        var path: String? = null
        val proj = arrayOf(MediaStore.MediaColumns.DATA)
        val cursor: Cursor? =
            requireContext().contentResolver.query(contentUri, proj, null, null, null)
        cursor?.let {
            if (cursor.moveToFirst()) {
                val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
                path = cursor.getString(column_index)
            }
        }
        cursor?.close()
        return path
    }
    /*

    * */
}