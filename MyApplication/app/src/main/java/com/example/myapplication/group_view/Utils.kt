package com.example.myapplication.group_view

import android.widget.EditText

//class Utils {
//    companion object{
//
//    }
//}

fun getStringFromEditText(et: EditText?): String {
    et?.let {
        return it.text.toString()
    }
    return ""
}