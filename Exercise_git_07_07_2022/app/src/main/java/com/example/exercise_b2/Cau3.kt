package com.example.exercise_b2

import android.util.Log

class Cau3 {
    lateinit var list:ArrayList<Int>

    constructor(list: ArrayList<Int>) {
        this.list = list
    }

    fun evenIndexValue() {
        list?.let { item ->
            for (i in 0..item.size - 1) {
                if (i % 2 == 0)
                    Log.d("Cau3", "gia tri tai phan tu thu $i: ${item[i]}")
            }
        }
    }
}