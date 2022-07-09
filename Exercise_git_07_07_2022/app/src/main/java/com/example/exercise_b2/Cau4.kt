package com.example.exercise_b2

import android.util.Log

class Cau4 {
    var string:String

    constructor(string: String) {
        this.string = string
    }
    fun printString(){
        if (string.length>5)
            Log.d("Cau4","Chuoi hon 5 ky tu $string")
        else Log.d("Cau4","Chuoi it hon 5 ky tu")
    }

}