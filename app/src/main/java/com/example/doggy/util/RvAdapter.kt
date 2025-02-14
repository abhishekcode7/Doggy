package com.example.doggy.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doggy.R
import com.example.doggy.dataClasses.DogData


class RvAdapter(private var dogList: List<String>) : RecyclerView.Adapter<RvAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_view, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val data = dogList[position]

        Glide.with(holder.itemView.context)
            .load(data)
            .into(holder.imageView)
    }

    fun updateItems(list:List<String>){
        dogList = list
        notifyDataSetChanged()
    }
}