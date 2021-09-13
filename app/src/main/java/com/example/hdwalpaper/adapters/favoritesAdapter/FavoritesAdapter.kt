package com.example.hdwalpaper.adapters.favoritesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hdwalpaper.R
import com.example.hdwalpaper.database.ImageEntity
import com.example.hdwalpaper.databinding.FavoritesBinding
import com.squareup.picasso.Picasso

class FavoritesAdapter(var onItemClickListener: OnItemClickListener):ListAdapter<ImageEntity,FavoritesAdapter.Vh>(MyDiffUtill()) {
    inner class Vh(var favoritesBinding: FavoritesBinding):RecyclerView.ViewHolder(favoritesBinding.root){
        fun onBind(imageEntity: ImageEntity,position: Int){
            if (imageEntity.image1== R.drawable.ic_love2){
                Picasso.get().load(imageEntity.image).placeholder(R.drawable.loading).into(favoritesBinding.imageMy)
                favoritesBinding.leek.setImageResource(imageEntity.image1!!)
            }
            favoritesBinding.leek.setOnClickListener {
                onItemClickListener.onItemClick(imageEntity,position,favoritesBinding.leek)
            }
            itemView.setOnClickListener {
                onItemClickListener.onItemClickP(imageEntity,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(FavoritesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
    class MyDiffUtill:DiffUtil.ItemCallback<ImageEntity>(){
        override fun areItemsTheSame(oldItem: ImageEntity, newItem: ImageEntity): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: ImageEntity, newItem: ImageEntity): Boolean {
            return oldItem.equals(newItem)
        }
    }

    interface OnItemClickListener{
        fun onItemClick(imageEntity: ImageEntity,position: Int,image:ImageView)
        fun onItemClickP(imageEntity: ImageEntity,position: Int)
    }
}