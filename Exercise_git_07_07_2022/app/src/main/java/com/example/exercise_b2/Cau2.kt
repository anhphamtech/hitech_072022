package com.example.exercise_b2

class Cau2 {
    fun findFirstText(list: ArrayList<String>): String {
        var s: String = ""
        var listS = arrayListOf("1", "2", "3")
        list?.let { item ->
            item.forEach { text ->
                s += text.first()
            }
//                s += text.get(0)
//                s += text.substring(0,1)
            item.map { it.first() }.toList().joinToString()
        }

        return s
    }
}