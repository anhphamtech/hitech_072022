package com.example.myapplication.group_view

import android.text.Editable
import android.widget.EditText

//Extension
fun EditText?.getStringOther(): String {
    return this?.text.getToString()
}

fun Editable?.getToString(): String {
    return this?.toString() ?: ""
}

fun EditText.changeSelected() {
    setOnFocusChangeListener { _, b ->
        isSelected = b
    }
}