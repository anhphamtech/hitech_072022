package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.adapter.ItemDrawerAdapter
import com.example.myapplication.fragment.NameFragment
import com.example.myapplication.model.ItemDrawerModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var ivMenu: AppCompatImageView
    private lateinit var rvcDrawer: RecyclerView

    private lateinit var draweAdaper: ItemDrawerAdapter
    private val listItem = arrayListOf<ItemDrawerModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewPager()
        initListener()
        Log.d("activityLife", "onCreate()")
        demoHashMap()
        initAdapterAndRecyclerView()
    }

    private fun initView() {
        tabLayout = findViewById(R.id.actMain_tabLayout)
        viewPager = findViewById(R.id.actMain_viewPager)
        drawerLayout = findViewById(R.id.actMain_dl)
        ivMenu = findViewById(R.id.actMain_ivMenu)
        rvcDrawer = findViewById(R.id.actMain_rcvDrawer)
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
            updateStatusDrawer()
//            moveNameFragment()
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
            else -> drawerLayout.openDrawer(GravityCompat.START)

        }
    }


    //Activity & Fragment
    /*
    * 1. Activity > Fragment
    * 2. Activity < Fragment
    * CPU, GPU, RAM
    * */

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        initView()
//        initViewPager()
//        initListener()
//        Log.d("activityLife", "1")
//        //1
//    }

    override fun onStart() {
        super.onStart()
        Log.d("activityLife", "2")
        //2
    }

    override fun onResume() {
        super.onResume()
        Log.d("activityLife", "3")
        //3
    }

    override fun onStop() {
        super.onStop()
        Log.d("activityLife", "5")
        //5
    }

    override fun onPause() {
        super.onPause()
        Log.d("activityLife", "4")
        //4
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activityLife", "6")
        //6
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activityLife", "5.1")
        //5.1
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

    val map = hashMapOf<String, Int>()

    private fun demoHashMap() {
        val list = arrayListOf<Int>()

        for (i in 0..9) {
            map["$i"] = i
            list.add(i)
        }

        //Phan tu thu 3
        //index -> ?
        //Thu tu -> ?

        //phan tu thu 5
//        Toast.makeText(this, map["4"].toString(), Toast.LENGTH_SHORT).show()
    }

    private fun initAdapterAndRecyclerView() {
        for (i in 0..19) {
            val icon = when (i) {
                0, 5 -> R.drawable.ic_beer
                1, 6 -> R.drawable.ic_champagne
                2, 7 -> R.drawable.ic_cinema
                3, 8 -> R.drawable.ic_confetti
                else -> R.drawable.ic_coffee
            }
            listItem.add(
                ItemDrawerModel(
                    title = getString(R.string.format_title_drawer, i + 1),
                    icon = icon
                )
            )
        }
        draweAdaper = ItemDrawerAdapter(listItem) { handleClickItemDrawer(it) }
        rvcDrawer.adapter = draweAdaper
        rvcDrawer.layoutManager = LinearLayoutManager(this)
        rvcDrawer.setHasFixedSize(true)
    }

    private fun handleClickItemDrawer(index: Int) {
        val temp = listItem.firstOrNull { it.statusSelected }
        temp?.let {
            temp.statusSelected = false
            val indexSelected = listItem.indexOf(temp)
            if (indexSelected != -1)
                draweAdaper.notifyItemChanged(indexSelected)
        }
//        if (temp != null) {
//
//        }
//        val itemSelected = listItem[index]
//        itemSelected.statusSelected = true
        listItem[index].statusSelected = true
        draweAdaper.notifyItemChanged(index)



//        draweAdaper.notifyDataSetChanged()
        draweAdaper.notifyItemChanged(index)
        draweAdaper.notifyItemRangeChanged(index, 10,)
        draweAdaper.notifyItemInserted(index)
        draweAdaper.notifyItemRemoved(index)
    }
}