package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.ItemDrawerModel

//higher function
class ItemDrawerAdapter(
    private val listData: List<ItemDrawerModel>,
    private val onClick: (Int) -> Unit
) :
    RecyclerView.Adapter<ItemDrawerAdapter.ItemDrawerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDrawerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drawer, parent, false)
        return ItemDrawerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemDrawerViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ItemDrawerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var ivIcon: AppCompatImageView
        private lateinit var tvTitle: TextView

        private fun initView() {
            ivIcon = itemView.findViewById(R.id.itemDrawer_iv)
            tvTitle = itemView.findViewById(R.id.itemDrawer_tv)
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }

        fun bindData(model: ItemDrawerModel) {
            initView()
            tvTitle.text = model.title
            ivIcon.setImageResource(model.icon)
            itemView.isSelected = model.statusSelected
        }

    }
}