package com.example.myapplication.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.R

class CalculatorActivity : AppCompatActivity() {

    companion object {
        private const val NO_ACTION = ""
        private const val NOT_SUBMIT = false
        private const val DONE_SUBMIT = true
    }

    private val listButton = arrayListOf<TextView>()
    private lateinit var tvInput: TextView
    private lateinit var tvOutput: TextView
    private var stringAction = NO_ACTION
    private var actionSubmit = NOT_SUBMIT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_temp)
        initView()
        initTextToListButton()
        initListener()
    }

    private fun initView() {
        tvInput = findViewById(R.id.tvInput)
        tvOutput = findViewById(R.id.tvOutput)
        for (i in 0..16) {
            when (i) {
                0 -> listButton.add(findViewById(R.id.tvNumber_7))
                1 -> listButton.add(findViewById(R.id.tvNumber_8))
                2 -> listButton.add(findViewById(R.id.tvNumber_9))
                3 -> listButton.add(findViewById(R.id.tvNumberDiv))
                4 -> listButton.add(findViewById(R.id.tvNumber_4))
                5 -> listButton.add(findViewById(R.id.tvNumber_5))
                6 -> listButton.add(findViewById(R.id.tvNumber_6))
                7 -> listButton.add(findViewById(R.id.tvNumberMul))
                8 -> listButton.add(findViewById(R.id.tvNumber_1))
                9 -> listButton.add(findViewById(R.id.tvNumber_2))
                10 -> listButton.add(findViewById(R.id.tvNumber_3))
                11 -> listButton.add(findViewById(R.id.tvNumberSub))
                12 -> listButton.add(findViewById(R.id.tvNumberAc))
                13 -> listButton.add(findViewById(R.id.tvNumber_0))
                14 -> listButton.add(findViewById(R.id.tvNumberDot))
                15 -> listButton.add(findViewById(R.id.tvNumberPlus))
                else -> listButton.add(findViewById(R.id.tvNumberSubmit))
            }
        }
    }

    private fun initTextToListButton() {
        listButton.forEachIndexed { index, textView ->
            textView.text = getString(
                when (index) {
                    0 -> R.string._7
                    1 -> R.string._8
                    2 -> R.string._9
                    3 -> R.string._div
                    4 -> R.string._4
                    5 -> R.string._5
                    6 -> R.string._6
                    7 -> R.string._mul
                    8 -> R.string._1
                    9 -> R.string._2
                    10 -> R.string._3
                    11 -> R.string._sub
                    12 -> R.string._aC
                    13 -> R.string._0
                    14 -> R.string._dot
                    15 -> R.string._plus
                    else -> R.string._submit
                }
            )
            when (index) {
                12 -> {
                    textView.setTextColor(ContextCompat.getColor(this, R.color.blue))
                }
                3, 7, 11, 15, 16 -> {
                    textView.setTextColor(ContextCompat.getColor(this, R.color.red))
                }
            }
        }
    }

    private fun initListener() {
        listButton.forEach { tv ->
            tv.setOnClickListener {
                onClickButton(tv)
            }
        }
    }

    private fun onClickButton(view: TextView) {
        val input = view.text.toString()

        when (input.toIntOrNull()) {
            //input = + - x : AC = .
            null -> {
                when (input) {
                    getString(R.string._aC) -> handleClickAc()
                    getString(R.string._submit) -> handleSubmit()
                    getString(R.string._dot) -> handleClickDot()
                    else -> handleGetAction(input)
                }
            }
            //input 0->9
            else -> addNumberToInput(tvInput.text.toString(), input)
        }
    }

    private fun addNumberToInput(data: String, input: String) {
        tvInput.text = getString(R.string.format_input, data, input)
    }

    private fun handleClickAc() {
        tvInput.text = ""
        tvOutput.text = "0"
        stringAction = NO_ACTION
        actionSubmit = NOT_SUBMIT
    }

    private fun handleClickDot(action: String = ".") {
        tvInput.text = getString(R.string.format_input, tvInput.text, action)
    }

    private fun handleSubmit() {
        val resInput = tvInput.text
        if (resInput.last().toString() != ".") {
            val listResult = resInput.split(stringAction)
            val numberOne = listResult[0].toDouble()
            val numberTwo = listResult[1].toDouble()
            tvOutput.text = when (stringAction) {
                getString(R.string._plus) -> numberOne + numberTwo
                getString(R.string._sub) -> numberOne - numberTwo
                getString(R.string._div) -> numberOne / numberTwo
                else -> numberOne * numberTwo
            }.toString()
            actionSubmit = DONE_SUBMIT
        }
    }

    private fun handleGetAction(action: String) {
//        val result = tvInput.text
        tvInput.text.let {
            when (actionSubmit) {
                NOT_SUBMIT -> {
                    if (it.last().toString() != "." && stringAction == NO_ACTION) {
                        stringAction = action
                        tvInput.text = getString(R.string.format_input, tvInput.text, action)
                    }
                }
                //DONE_SUBMIT
                else -> {
                    val resultZero = tvOutput.text.toString()
                    val number = when (resultZero.last().toString() == "0") {
                        true -> resultZero.split(".")[0]
                        else -> resultZero
                    }
                    stringAction = action
                    addNumberToInput(number, action)
                    actionSubmit = NOT_SUBMIT
                }
            }
        }
    }
}