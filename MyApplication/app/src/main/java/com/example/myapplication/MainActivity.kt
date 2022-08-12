package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.core.widget.ImageViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.fragment.NameFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var drawerLayout: DrawerLayout
    lateinit var ivMenu: AppCompatImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewPager()
        initListener()
        Log.d("activityLife", "onCreate()")
    }

    private fun initView() {
        tabLayout = findViewById(R.id.actMain_tabLayout)
        viewPager = findViewById(R.id.actMain_viewPager)
//        drawerLayout = findViewById(R.id.actMain_dl)
        ivMenu = findViewById(R.id.actMain_ivMenu)
//        drawerLayout.closeDrawer(GravityCompat.START)
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

        ivMenu.setOnClickListener {
//            updateStatusDrawer()
            moveNameFragment()
        }
//        finish()
    }

    private fun initViewPager() {
        val adapterViewPager = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapterViewPager
    }

    private fun updateStatusDrawer() {
        when (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            true -> drawerLayout.closeDrawer(GravityCompat.END)
            else -> drawerLayout.closeDrawer(GravityCompat.START)

        }
    }


    //Activity & Fragment
    /*
    * 1. Activity > Fragment
    * 2. Activity < Fragment
    * CPU, GPU, RAM
    * */

    override fun onStart() {
        super.onStart()
        Log.d("activityLife", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activityLife", "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("activityLife", "onStop()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activityLife", "onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activityLife", "onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activityLife", "onRestart()")
    }

    private fun moveNameFragment() {
        val fragment = NameFragment()
        val tag = fragment::class.java.simpleName
        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.actMain_flMain, fragment,tag)
            add(R.id.actMain_flMain, fragment, tag)
            //first in last out
            addToBackStack(tag)
            commit()
            //Name
            //Age
            //Info
        }
    }
}