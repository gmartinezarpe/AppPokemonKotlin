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

        val til_user = findViewById<TextInputLayout>(R.id.til_user)
        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val button_login = findViewById<Button>(R.id.button_login)

        button_login.setOnClickListener{
            val intent = Intent(this@MainActivity,HomeLayout::class.java )
            startActivity(intent)
        }

    }
}