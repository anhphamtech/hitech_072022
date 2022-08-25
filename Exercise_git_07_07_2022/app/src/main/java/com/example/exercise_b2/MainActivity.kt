package com.example.exercise_b2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //===================== CÂU 1==========================
        val list = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        list?.let {
            var mean = Cau1(list)
            Log.d("Cau1", "gia tri trung binh: ${mean.calMeanList(it)}")
        }
        //===================== CÂU 2==========================
        var ltString = arrayListOf<String>("Phuong", "Hitech", "Android", "Basic")
        ltString?.let {
            var firstChar = Cau2()
            Log.d("Cau2", "chu dau tien: ${firstChar.findFirstText(it)}")
        }
        //===================== CÂU 3==========================
        var listIndex= arrayListOf<Int>(1,7,5,9,4,9,5,7,11,8,7,2)
        listIndex?.let {
            var evenIndex=Cau3(listIndex)
            evenIndex.evenIndexValue()
        }

        //===================== CÂU 4==========================
        var string="Phuon"
        string?.let {
            var showString=Cau4(string)
            showString.printString()
        }

    }

    fun cau1(){}

}