package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Exercise 1
        val array = intArrayOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
        Log.d("Exercise 1","Average Array: ${averageList(*array)}")

        // Exercise 2
        val listStr = mutableListOf("Kratos", "Ophion", "Thanatos", "Leto", "Iris", "Nemesis")
        val result = getFirstChar(*listStr.toTypedArray())

        Log.d("Exercise 2", "List String: $listStr")
        Log.d("Exercise 2", "First character: $result")

        // Exercise 3
        val listNum = intArrayOf(1 ,2 ,3 ,4 ,5, 6, 7, 8)
        Log.d("Exercise 3", "Element in even position:")
        posIndexEven(*listNum)

        // Exercise 4
        val god1 = "Gaia"
        val god2 = "Apollo"
        overFiveChar(god1)
        overFiveChar(god2)
    }
}

fun averageList(vararg listNumber: Int): Double
{
    var total = 0.0
    for (number in listNumber)
    {
        total += number
    }
    return total / listNumber.size
}

fun getFirstChar(vararg listStr: String): String
{
    var listFirstCharacter = ""
    for (Element in listStr)
    {
        listFirstCharacter += Element[0].toString()
    }
    return listFirstCharacter
}

fun posIndexEven(vararg listNumber: Int)
{
    for (index: Int in 0..listNumber.lastIndex)
    {
        if (index % 2 == 0)
        {
            Log.d("Exercise 3", "Number[$index] = ${listNumber[index]}")
        }
    }
}

fun overFiveChar(str: String)
{
    if (str.length > 5)
        Log.d("Exercise 4", "String $str length ${str.length}")
    else
        Log.d("Exercise 4", "String $str has no length greater than 5")
}