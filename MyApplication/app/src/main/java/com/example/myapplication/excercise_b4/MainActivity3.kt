package com.example.myapplication.excercise_b4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class MainActivity3 : AppCompatActivity() {
    lateinit var num1:EditText
    lateinit var num2:EditText
    lateinit var num3:EditText
    var getSum:TextView?=null
    var btnSum:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        initView()
        iniListener()
    }

    private fun initView(){
        num1=findViewById(R.id.var1)
        num2=findViewById(R.id.var2)
        num3=findViewById(R.id.var3)
        getSum=findViewById(R.id.tv_sum)
    }
    private fun iniListener(){

        getSum?.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                val number1=num1.fromEdittextToDouble()
                val number2=num2.fromEdittextToDouble()
                val number3=num3.fromEdittextToDouble()
                var summ:Double=number1+number2+number3
                Toast.makeText(this@MainActivity3,"Sum= $summ",Toast.LENGTH_SHORT).show()
            }

        })
    }

}