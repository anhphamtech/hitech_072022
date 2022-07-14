package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    //Ca 2 deu duoc
    var i = 0
    var i1: Int = 0
    var i2: Int? = null
//    lateinit var i3 : Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_framelayout)
        var user = User()
        //hot ket : Shift + F6 -> change all project
        user.fullName
        user.age
        sum(i, i1)
        sum(i1, i2)
        i2?.let {
            sum(i1, it)
        }
//        if(i2 !=null){
//            sum(i1, i2!!)
//        }

        printName()
        printName("Phuong")
        printName("Vu")

        demoFor()
    }

    fun sum(a: Int, b: Int?): Int {
        //1
        return when (b != null) {
            true -> a + b
            else -> a
        }

        //2
//        return if (b != null)
//            a + b
//        else a
    }

//    fun sumShort(a: Int, b: Int) = a + b

    private fun printName(name: String = "A") {

        val firstChar = name.substring(0, 1)
//        Log.d("hitechUni", firstChar.uppercase())

        //1
        //Search the same word in class -> Alt + J
        var fullName = ""
        when (firstChar) {
            "P" -> fullName = "Phuong"
            "V" -> fullName = "Vu"
            else -> fullName = "Anh"
        }

        //2
        val name2 = when (firstChar) {
            "P" -> "Phuong"
            "V" -> "Vu"
            else -> "Anh"
        }

        Log.d("hitechUni", "$fullName - ${name2}2")
    }

    private fun demoFor() {
        //1
        var list1 = ArrayList<Int>()
        var list2 = ArrayList<String>()
        var list3 = ArrayList<Double>()
        var list4 = ArrayList<User>()
        //2
        var list = arrayListOf<Int>()

//        (i =11;i<20;i++)

        for (i in 0..10) {
            list.add(i)
        }

        for (i in 11 until 20) {
            list.add(i)
        }

        list.remove(8)
        list.removeAt(6)

        //List
        /* Index
        * Start 0
        * */

        /* Size
        * Start 1
        * */
        list.size

        //No need index
        list.forEach { item ->
            Log.d("demoFor", "demoFor : $item")
        }

        list4.forEach {
            it.fullName
            it.age
        }

        //Need index for logic
        for (index in 0 until list.size) {
            Log.d("demoFor", "demoFor index : ${list[index]}")
        }

    }

    //1
    fun noVoid(): Unit {

    }

    //2
    fun noVoid1(){

    }
}