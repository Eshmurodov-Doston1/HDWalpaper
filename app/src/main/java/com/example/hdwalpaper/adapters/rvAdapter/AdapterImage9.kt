package com.example.hdwalpaper.adapters.rvAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hdwalpaper.R
import com.example.hdwalpaper.databinding.ItemImageBinding
import com.squareup.picasso.Picasso

class AdapterImage9(var onItemClickListener: OnItemClickListener):PagingDataAdapter<com.example.hdwalpaper.models.Result,AdapterImage9.Vh>(MyDiffUtill()) {
    inner class Vh(var itemImageBinding: ItemImageBinding):RecyclerView.ViewHolder(itemImageBinding.root){
        fun onBid(result: com.example.hdwalpaper.models.Result,position: Int){
            Picasso.get().load(result.urls.thumb).placeholder(R.drawable.loading).into(itemImageBinding.imageMy)
//            itemImageBinding.leek.setOnClickListener {
//               onItemClickListener.leekClick(result,position)
//            }
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(result,position)
            }
        }
    }

    class MyDiffUtill:DiffUtil.ItemCallback<com.example.hdwalpaper.models.Result>(){
        override fun areItemsTheSame(oldItem: com.example.hdwalpaper.models.Result, newItem: com.example.hdwalpaper.models.Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: com.example.hdwalpaper.models.Result, newItem: com.example.hdwalpaper.models.Result): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        getItem(position)?.let { holder.onBid(it,position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    interface OnItemClickListener{
        fun onItemClick(result: com.example.hdwalpaper.models.Result,position: Int)
        fun leekClick(result: com.example.hdwalpaper.models.Result,position: Int)
    }

}