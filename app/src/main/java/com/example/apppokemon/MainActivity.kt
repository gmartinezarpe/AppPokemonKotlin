package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaramos las variables

        val am_til_tv_user = findViewById<TextInputLayout>(R.id.am_til_tv_user)
        val am_til_tv_password = findViewById<TextInputLayout>(R.id.am_til_tv_password)
        val am_til_btn_login = findViewById<Button>(R.id.am_til_btn_login)

        am_til_btn_login.setOnClickListener{
            val intent = Intent(this, HomeLayout::class.java )
            startActivity(intent)
        }

    }
}