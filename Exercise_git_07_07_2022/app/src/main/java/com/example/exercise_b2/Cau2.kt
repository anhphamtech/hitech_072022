package com.example.exercise_b2

class Cau2 {
    fun findFirstText(list: ArrayList<String>): String {
        var s: String = ""
        list?.let { item ->
            item.forEach { text ->
                s += text.first()
            }
//                s += text.get(0)
//                s += text.substring(0,1)
        }
        return s
    }
}