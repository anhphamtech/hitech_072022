package com.example.myapplication.excercise_b4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.group_view.changeSelected

class MainActivity3 : AppCompatActivity() {
    lateinit var num1: EditText
    lateinit var num2: EditText
    lateinit var num3: EditText
    var getSum: TextView? = null
    var btnSum: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        initView()
        iniListener()
    }

    private fun initView() {
//        num1=findViewById(R.id.var1)
//        num2=findViewById(R.id.var2)
//        num3=findViewById(R.id.var3)
        getSum = findViewById(R.id.tv_sum)
        val viewNumber1 = findViewById<ConstraintLayout>(R.id.icl_number1)
        val edt1: EditText = viewNumber1.findViewById(R.id.item_edt1)
        edt1.setText("123")
        edt1.changeSelected()

        val viewNumber2 = findViewById<View>(R.id.icl_number2)
        val edt2 = viewNumber2.findViewById<EditText>(R.id.item_edt1)
        edt2.setText("456")
        edt2.changeSelected()

        val viewNumber3 = findViewById<View>(R.id.icl_number3)
        val edt3 = viewNumber3.findViewById<EditText>(R.id.item_edt1)
        edt3.setText("789")
        edt3.changeSelected()

        val imageView: ImageView = findViewById(R.id.actMain_ivCenter)
        imageView.isSelected = true

        imageView.setOnClickListener {
            imageView.isSelected = !imageView.isSelected
        }
    }

    private fun iniListener() {
        getSum?.isEnabled = false
        getSum?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
//                val number1 = num1.fromEdittextToDouble()
//                val number2 = num2.fromEdittextToDouble()
//                val number3 = num3.fromEdittextToDouble()
//                val sumNew = arrayListOf(number1, number2, number3).average()
//                var summ: Double = number1 + number2 + number3
//                Toast.makeText(this@MainActivity3, "Sum= $sumNew", Toast.LENGTH_SHORT).show()
            }

        })
    }

}