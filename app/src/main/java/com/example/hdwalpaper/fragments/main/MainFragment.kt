package com.example.hdwalpaper.fragments.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.hdwalpaper.R
import com.example.hdwalpaper.adapters.main.ViewpagerAdapter
import com.example.hdwalpaper.databinding.FragmentMainBinding
import com.example.hdwalpaper.utils.LocaleHelper
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class MainFragment : Fragment() {
    lateinit var fragmentMainBinding: FragmentMainBinding
    lateinit var root:View
    lateinit var sharedPreferences: SharedPreferences
    lateinit var viewPagerAdapter: ViewpagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false)
        root = fragmentMainBinding.root
        fragmentMainBinding.apply {
            sharedPreferences = requireActivity().getSharedPreferences("Theme",0)
            val color = sharedPreferences.getString("color", "#DFF1EEEE")
            val onAttach = LocaleHelper.onAttach(requireContext())
            bottomNavigation.menu.findItem(R.id.home).title = onAttach.getString(R.string.photos)
            bottomNavigation.menu.findItem(R.id.favorites).title = onAttach.getString(R.string.favorites)
            bottomNavigation.menu.findItem(R.id.settings).title = onAttach.getString(R.string.settings)
            loadView()
            bottomNavigation.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home->{
                        viewpager2.currentItem=0
                        bottomNavigation.menu.findItem(R.id.home).isChecked=true
                        bottomNavigation.menu.findItem(R.id.home).setIcon(R.drawable.ic_images2)
                        bottomNavigation.menu.findItem(R.id.favorites).setIcon(R.drawable.ic_love1)
                        bottomNavigation.menu.findItem(R.id.settings).setIcon(R.drawable.ic_settings1)
                    }
                    R.id.favorites->{
                        viewpager2.currentItem=1
                        bottomNavigation.menu.findItem(R.id.favorites).isChecked=true
                        bottomNavigation.menu.findItem(R.id.home).setIcon(R.drawable.ic_images1)
                        bottomNavigation.menu.findItem(R.id.favorites).setIcon(R.drawable.ic_love2)
                        bottomNavigation.menu.findItem(R.id.settings).setIcon(R.drawable.ic_settings1)
                    }
                    R.id.settings->{
                        viewpager2.currentItem=2
                        bottomNavigation.menu.findItem(R.id.settings).isChecked=true
                        bottomNavigation.menu.findItem(R.id.home).setIcon(R.drawable.ic_images1)
                        bottomNavigation.menu.findItem(R.id.favorites).setIcon(R.drawable.ic_love1)
                        bottomNavigation.menu.findItem(R.id.settings).setIcon(R.drawable.ic_settings2)
                    }
                }
                true
            }
        }
        return root
    }

    private fun loadView() {
        fragmentMainBinding.apply {
            viewPagerAdapter = ViewpagerAdapter(requireActivity())
            viewpager2.isUserInputEnabled=false
            viewpager2.adapter = viewPagerAdapter
            viewpager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when(position){
                        0->{
                            bottomNavigation.menu.findItem(R.id.home).isChecked=true
                            bottomNavigation.menu.findItem(R.id.home).setIcon(R.drawable.ic_images2)
                            bottomNavigation.menu.findItem(R.id.favorites).setIcon(R.drawable.ic_love1)
                            bottomNavigation.menu.findItem(R.id.settings).setIcon(R.drawable.ic_settings1)
                        }
                        1->{
                            bottomNavigation.menu.findItem(R.id.favorites).isChecked=true
                            bottomNavigation.menu.findItem(R.id.home).setIcon(R.drawable.ic_images1)
                            bottomNavigation.menu.findItem(R.id.favorites).setIcon(R.drawable.ic_love2)
                            bottomNavigation.menu.findItem(R.id.settings).setIcon(R.drawable.ic_settings1)
                        }
                        2->{
                            bottomNavigation.menu.findItem(R.id.settings).isChecked=true
                            bottomNavigation.menu.findItem(R.id.home).setIcon(R.drawable.ic_images1)
                            bottomNavigation.menu.findItem(R.id.favorites).setIcon(R.drawable.ic_love1)
                            bottomNavigation.menu.findItem(R.id.settings).setIcon(R.drawable.ic_settings2)
                        }
                    }
                }
            })
        }

    }
}