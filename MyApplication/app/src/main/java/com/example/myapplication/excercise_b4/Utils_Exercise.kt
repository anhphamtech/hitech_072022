package com.example.myapplication.excercise_b4

import android.widget.EditText

fun EditText?.fromEdittextToDouble():Double{
    return if (this?.text.toString()=="Null" ||this?.text.toString()=="") {
        0.0
    }
    else this?.text.toString().toDouble()
}