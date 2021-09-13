package com.example.hdwalpaper.adapters.color

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hdwalpaper.databinding.ItemThemeBinding

class RvColor(var onItemClicListener:OnItemClickListener,var listColor:List<String>):RecyclerView.Adapter<RvColor.Vh>() {
    inner class Vh(var itemThemeBinding: ItemThemeBinding):RecyclerView.ViewHolder(itemThemeBinding.root){
        fun onBind(color:String,position: Int){
            itemThemeBinding.color.setColor(Color.parseColor(color))
            itemThemeBinding.color.setOnClickListener {
                onItemClicListener.onItemClick(color,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemThemeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(listColor[position],position)
    }

    override fun getItemCount(): Int {
        return listColor.size
    }
    interface OnItemClickListener{
        fun onItemClick(color:String,position: Int)
    }
}