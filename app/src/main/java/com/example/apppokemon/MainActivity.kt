package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.apppokemon.controllers.AuthController
import com.example.apppokemon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaramos las variables

        val til_user = findViewById<TextInputLayout>(R.id.am_til_tv_user)
        val til_password = findViewById<TextInputLayout>(R.id.am_til_tv_password)
        val btn_login = findViewById<Button>(R.id.am_til_btn_login)
        val btn_create_ntrainer = findViewById<Button>(R.id.am_til_btn_create_new_trainer)

        btn_login.setOnClickListener{
            val email = til_user.editText?.text.toString()
            val password = til_password.editText?.text.toString()

            val emailValid = TilValidator(til_user).required().email().isValid()
            val passwordValid = TilValidator(til_password).required().isValid()

            if (emailValid && passwordValid) {
                AuthController(this).login(email,  password)
            } else {
                Toast.makeText(this, "Campos invalidos", Toast.LENGTH_SHORT).show()
            }

            //Toast.makeText(this, emailValid.toString(), Toast.LENGTH_SHORT).show()
            //val intent = Intent(this, HomeLayout::class.java )
            //startActivity(intent)
        }

        btn_create_ntrainer.setOnClickListener{
            val intent = Intent(this, CreateNewTrainer::class.java )
            startActivity(intent)
        }

    }
}