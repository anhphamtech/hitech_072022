package com.example.myapplication

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.fragment.AgeFragment
import com.example.myapplication.fragment.InfoFragment
import com.example.myapplication.fragment.NameFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount() = 3

    override fun getItem(position: Int) = when (position) {
        0 -> NameFragment()
        1 -> AgeFragment()
        //2
        else -> InfoFragment()
    }

//    override fun getItem(position: Int): Fragment {
//        return when (position) {
//            0 -> NameFragment()
//            else -> AgeFragment()
//        }
//    }
}