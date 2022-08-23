package com.example.myapplication.adapter

import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.R
import com.example.myapplication.model.ContactModel
import java.io.File

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

        private fun initView() {
            tvHeader = itemView.findViewById(R.id.itemContact_tvHeader)
            tvName = itemView.findViewById(R.id.itemContact_tvName)
            tvPhone = itemView.findViewById(R.id.itemContact_tvPhone)
            ivHeader = itemView.findViewById(R.id.itemContact_ivHeader)
            itemView.setOnClickListener {
                onClickContact(adapterPosition)
            }
        }

        fun bindData(model: ContactModel) {
            initView()
            tvName.text = model.name
            tvPhone.text = model.phone
            when (model.image.isEmpty()) {
                true -> {
                    tvHeader.text = model.name.first().toString()
                    tvHeader.visibility = View.VISIBLE
                }
                else -> {
//                    val bitmap = BitmapFactory.decodeFile(model.image)
//                    ivHeader.setImageBitmap(bitmap)
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        itemView.context.contentResolver,
                        Uri.parse(model.image)
                    )
                    ivHeader.setImageBitmap(MediaStore.Images.Media.getBitmap(
                        itemView.context.contentResolver,
                        Uri.parse(model.image)
                    ))
                }
            }
        }
    }
}