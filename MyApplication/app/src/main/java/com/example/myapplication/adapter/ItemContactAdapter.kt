package com.example.myapplication.adapter

import android.content.ContentUris
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.R
import com.example.myapplication.model.ContactModel
import java.io.BufferedInputStream
import java.io.InputStream


class ItemContactAdapter(
    private val listContact: List<ContactModel>,
    val onClickContact: (Int) -> Unit
) : RecyclerView.Adapter<ItemContactAdapter.ItemContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ItemContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemContactViewHolder, position: Int) {
        holder.bindData(listContact[position])
    }

    override fun getItemCount(): Int {
        return listContact.size
    }

    inner class ItemContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var tvHeader: TextView
        private lateinit var tvName: TextView
        private lateinit var tvPhone: TextView
        private lateinit var ivHeader: AppCompatImageView
        private lateinit var ivLike: AppCompatImageView

        private fun initView() {
            tvHeader = itemView.findViewById(R.id.itemContact_tvHeader)
            tvName = itemView.findViewById(R.id.itemContact_tvName)
            tvPhone = itemView.findViewById(R.id.itemContact_tvPhone)
            ivHeader = itemView.findViewById(R.id.itemContact_ivHeader)
            ivLike = itemView.findViewById(R.id.itemContact_ivLike)
            itemView.setOnClickListener {
                onClickContact(adapterPosition)
            }
        }

        fun bindData(model: ContactModel) {
            initView()
            tvName.text = model.name
            tvPhone.text = model.phone
            ivLike.isSelected = model.statusLike
            when (model.image.isEmpty()) {
                true -> {
                    tvHeader.text = model.name.first().toString()
                    tvHeader.visibility = View.VISIBLE
                    ivHeader.visibility = View.INVISIBLE
                }
                else -> {
                    tvHeader.visibility = View.INVISIBLE
                    ivHeader.visibility = View.VISIBLE
                    val photo_stream: InputStream =
                        ContactsContract.Contacts.openContactPhotoInputStream(
                            itemView.context.contentResolver,
                            ContentUris.withAppendedId(
                                ContactsContract.Contacts.CONTENT_URI,
                                model.idPhoto.toLong()
                            )
                        )
                    val buf = BufferedInputStream(photo_stream)
                    val my_btmp = BitmapFactory.decodeStream(buf)
                    ivHeader.load(my_btmp) {
                        transformations(CircleCropTransformation())
                    }
                }
            }
        }
    }
}