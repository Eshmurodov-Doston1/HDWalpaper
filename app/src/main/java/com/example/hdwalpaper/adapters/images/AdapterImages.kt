package com.example.hdwalpaper.adapters.images

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hdwalpaper.fragments.photos.ImagesViewPagerFragment

class AdapterImages(var list1: List<String>,fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list1.size
    }

    override fun createFragment(position: Int): Fragment {
        return ImagesViewPagerFragment.newInstance(list1[position],position)
    }
}