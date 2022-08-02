package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutButtonFacebook = findViewById<View>(R.id.layout_SignIn_Facebook)
        val imgButtonFacebook = layoutButtonFacebook.findViewById<ImageView>(R.id.Btn_imageView)
        imgButtonFacebook.setImageResource(R.drawable.facebook_icon)

        val layoutButtonGoogle = findViewById<View>(R.id.layout_SignIn_Google)
        val imgButtonGoogle = layoutButtonGoogle.findViewById<ImageView>(R.id.Btn_imageView)
        imgButtonGoogle.setImageResource(R.drawable.google_icon)

        layoutButtonFacebook.setOnClickListener {
            layoutButtonFacebook.isPressed = !layoutButtonFacebook.isPressed
        }

        layoutButtonGoogle.setOnClickListener {
            layoutButtonGoogle.isPressed = !layoutButtonGoogle.isPressed
        }

        val eTextName = findViewById<EditText>(R.id.eText_Name)

        val tvLogin = findViewById<TextView>(R.id.Tv_Login)
        tvLogin.setOnClickListener {
            if (eTextName.visibility == View.VISIBLE)
            {
                eTextName.visibility = View.INVISIBLE
            }
            else
            {
                eTextName.visibility = View.VISIBLE
            }
        }
    }
}
