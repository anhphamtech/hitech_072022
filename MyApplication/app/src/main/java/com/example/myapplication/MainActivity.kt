package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var layoutButtonFacebook: View
    private lateinit var imgButtonFacebook: ImageView
    private lateinit var layoutButtonGoogle: View
    private lateinit var imgButtonGoogle: ImageView
    private lateinit var eTextName: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvTitle: TextView
    private lateinit var tvLogin: TextView

    //variable local : {} -> block code

    //variable global :
//    var iGlobal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
        loadData()
    }

    private fun loadData() {
        imgButtonFacebook.setImageResource(R.drawable.facebook_icon)
        imgButtonGoogle.setImageResource(R.drawable.google_icon)
    }

    private fun initView() {
        layoutButtonFacebook = findViewById(R.id.layout_SignIn_Facebook)
        imgButtonFacebook = layoutButtonFacebook.findViewById(R.id.Btn_imageView)

        layoutButtonGoogle = findViewById(R.id.layout_SignIn_Google)
        imgButtonGoogle = layoutButtonGoogle.findViewById(R.id.Btn_imageView)

        eTextName = findViewById(R.id.eText_Name)
        btnLogin = findViewById(R.id.Btn_Login)
        tvTitle = findViewById(R.id.Tv_Title2)
        tvLogin = findViewById(R.id.Tv_Login)
    }

    private fun initListener() {
        layoutButtonFacebook.setOnClickListener {
            layoutButtonFacebook.isPressed = !layoutButtonFacebook.isPressed
        }

        layoutButtonGoogle.setOnClickListener {
            layoutButtonGoogle.isPressed = !layoutButtonGoogle.isPressed
        }

        tvLogin.setOnClickListener {
            //suggest
//            val textLogin: Int
//            val textTitle: String
//            val textBtnLogin: Int
//            val statusVisibility: Int
//            when (eTextName.visibility) {
//                View.VISIBLE -> {
//                    textLogin = R.string.sign_up
//                    textTitle = getString(R.string._in)
//                    textBtnLogin = R.string.sign_in
//                    statusVisibility = View.INVISIBLE
//                }
//                else -> {
//                    textLogin = R.string.sign_in
//                    textTitle = getString(R.string._up)
//                    textBtnLogin = R.string.sign_up
//                    statusVisibility = View.VISIBLE
//                }
//            }
//            eTextName.visibility = statusVisibility
//            tvLogin.text = getString(textLogin)
//            tvTitle.text = getString(R.string.continue_format, textTitle)
//            btnLogin.text = getString(textBtnLogin)

            if (eTextName.visibility == View.VISIBLE) {
                eTextName.visibility = View.GONE
//                eTextName.visibility = View.INVISIBLE
                tvLogin.text = getString(R.string.sign_up)
                tvTitle.text = getString(R.string.continue_format, "in")
                btnLogin.text = getString(R.string.sign_in)
            } else {
                eTextName.visibility = View.VISIBLE
                tvLogin.text = getString(R.string.sign_in)
                tvTitle.text = getString(R.string.continue_format, "up")
                btnLogin.text = getString(R.string.sign_up)
            }
        }
    }
}
