package com.example.myapplication.group_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.R

class Main2Activity : AppCompatActivity() {

    var etEmail: EditText? = null
    var etPassword: EditText? = null
    var btnShow: Button? = null
    var tvShow: TextView? = null
    var llRoot: LinearLayoutCompat? = null
    var cbBox: CheckBox? = null

    var email = ""
    var passWord = ""
    val textWatcherPassWord = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //login here
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //login here
        }

        override fun afterTextChanged(p0: Editable?) {
            passWord = p0.getToString()
            //login here
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
//        getEmailAndPassword()
        initListener()
    }

    private fun initView() {
        /*
        * 1. Find view by Id
        * 2. View binding
        * 3. Data binding
        * */

        //1. Find view by Id
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnShow = findViewById(R.id.btnShow)
        tvShow = findViewById(R.id.tv_Show)
        llRoot = findViewById(R.id.llRoot)
        cbBox = findViewById(R.id.cbBox)
        cbBox?.isSelected = true
    }

    private fun getEmailAndPassword() {
        //1. Get text
        // function ? A : B
        //ex: a > 0 ? A : B
        //        val email = etEmail?.text ?: ""
//        val email = etEmail?.text.toString()
        val email = getStringFromEditText(etEmail)
        // "null"
        val passWord = etPassword.getStringOther()
    }

    private fun initListener() {
        //new View.Seton....
        btnShow?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                //Scope
                //block code
//                val email = getStringFromEditText(etEmail)
//                // "null"
//                val passWord = etPassword.getStringOther()
                Toast.makeText(this@Main2Activity, "$email - $passWord", Toast.LENGTH_SHORT).show()
            }
        })

        tvShow?.setOnClickListener {
            Toast.makeText(this@Main2Activity, "$email - $passWord", Toast.LENGTH_SHORT).show()
        }

        llRoot?.setOnLongClickListener {
            Toast.makeText(this@Main2Activity, "$email", Toast.LENGTH_SHORT).show()
            true
        }

        tvShow?.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                return true
            }
        })

        etEmail?.addTextChangedListener {

        }

        etEmail?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //login here
                var i =0
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //login here
                var i =0
            }

            override fun afterTextChanged(p0: Editable?) {
                var i =0
                email = p0.getToString()
                //login here
            }

        })

        etPassword?.addTextChangedListener(textWatcherPassWord)
    }

    override fun onDestroy() {
        etPassword?.removeTextChangedListener(textWatcherPassWord)
        super.onDestroy()
    }

//    private fun getStringFromEditText(et: EditText?): String {
//        et?.let {
//            return it.text.toString()
//        }
//        return ""
//    }
}