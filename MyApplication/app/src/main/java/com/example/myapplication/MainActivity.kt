package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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