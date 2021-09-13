package com.example.hdwalpaper.adapters.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hdwalpaper.fragments.favorites.FavoritesFragment
import com.example.hdwalpaper.fragments.photos.ImagesFragment
import com.example.hdwalpaper.fragments.settings.SettingsFragment

class ViewpagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
          0->{
              ImagesFragment()
          }
            1->{
                FavoritesFragment()
            }
            2->{
                SettingsFragment()
            }
          else->{
              ImagesFragment()
          }
        }
    }

}