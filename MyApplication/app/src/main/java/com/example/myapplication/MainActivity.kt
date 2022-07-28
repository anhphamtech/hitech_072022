package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.widget.TextView

=======
import android.util.Log
>>>>>>> e48132c0b4ad8dfabd3d71b1d2b3941383ef1898

class MainActivity : AppCompatActivity() {

    //Ca 2 deu duoc
    var i = 0
    var i1: Int = 0
    var i2: Int? = null
//    lateinit var i3 : Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

        // Exercise 1
        val array = intArrayOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

        val textview1 = findViewById<TextView>(R.id.TextView4)
        val textview2 = findViewById<TextView>(R.id.TextView1)

        // Print value
        for (index in 0..array.lastIndex)
        {
            textview1.append(array[index].toString())
            if (index != array.lastIndex)
            {
                textview1.append(", ")
            }
        }
//        textview2.text = averageList(1).toString()
        textview2.text = averageList(*array).toString()

        // Exercise 2
        val listStr = mutableListOf("Kratos", "Ophion", "Thanatos", "Leto", "Iris", "Nemesis")
        val result = getFirstChar(*listStr.toTypedArray())

        val textview3 = findViewById<TextView>(R.id.TextView6)
        val textview4 = findViewById<TextView>(R.id.TextView8)

        // Print value
        textview3.text = listStr.toString()
        textview4.text = result

        // Exercise 3
        val listNum = intArrayOf(1 ,2 ,3 ,4 ,5, 6, 7, 8)
        val numEvenPos = posIndexEven(*listNum)

        val textview5 = findViewById<TextView>(R.id.TextView10)
        val textview6 = findViewById<TextView>(R.id.TextView12)

        // Print value
        for (index in 0..listNum.lastIndex)
        {
            textview5.append(listNum[index].toString())
            if (index != listNum.lastIndex)
            {
                textview5.append(", ")
            }
        }
        textview6.text = numEvenPos.toString()

        // Exercise 4
        val god1 = "Gaia"
        val god2 = "Apollo"
        val result1 = overFiveChar(god1)
        val result2 = overFiveChar(god2)

        val textview7 = findViewById<TextView>(R.id.TextView14)
        val textview8 = findViewById<TextView>(R.id.TextView16)

        // Print value
        textview7.text = god2
        textview8.text = result2
=======
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

>>>>>>> e48132c0b4ad8dfabd3d71b1d2b3941383ef1898
    }
}

fun averageList(vararg listNumber: Int): Double
{
    var total = 0.0
    listNumber.forEach {  }
    for (number in listNumber)
    {
        total += number
    }
//    listNumber.average()
    return total / listNumber.size
}

fun getFirstChar(vararg listStr: String): String
{
    var listFirstCharacter = ""
    for (Element in listStr)
    {
        listFirstCharacter += Element[0].toString()
//        listFirstCharacter += Element.first()
    }
    return listFirstCharacter
}

fun posIndexEven(vararg listNumber: Int): List<Int>
{
    val numEven = mutableListOf<Int>()
    for (index: Int in 0..listNumber.lastIndex)
    {
        if (index % 2 == 0)
        {
            numEven.add(listNumber[index])
        }
    }

    return numEven
}

fun overFiveChar(str: String): String
{
    return if (str.length > 5)
        "String $str length ${str.length}"
    else
        "String $str has no length greater than 5"
}