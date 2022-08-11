package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewPager()
        initListener()

    }

    private fun initView() {
        tabLayout = findViewById(R.id.actMain_tabLayout)
        viewPager = findViewById(R.id.actMain_viewPager)
    }

    private fun initListener() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        tabLayout.setupWithViewPager(viewPager)

//        tabLayout.getTabAt(1)?.select()
//        viewPager.currentItem = 1

        //index : start = 0
        //size/length: start = 1
    }

    private fun initViewPager() {
        val adapterViewPager = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapterViewPager
    }

}