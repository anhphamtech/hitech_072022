package com.example.myapplication.excercise_b4

import android.widget.EditText

fun EditText?.fromEdittextToDouble():Double{
    return if (this == null ||this.text.toString().isEmpty()) {
        0.0
    }
    else this.text.toString().toDouble()
}