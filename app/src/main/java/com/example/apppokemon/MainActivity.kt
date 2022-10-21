package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.apppokemon.controllers.AuthController
import com.example.apppokemon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import roomDataBase.DB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val room = Room.databaseBuilder(this, DB::class.java,"database-hola").allowMainThreadQueries().build()


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
                lifecycleScope.launch{
                    val response = room.daoUsuario().Login(email,password)
                    if(response.size == 1) {
                        Toast.makeText(this@MainActivity, "Login Exitoso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity, HomeLayout::class.java )
                        startActivity(intent)

                    }else{
                        Toast.makeText(this@MainActivity, "Login Invalido", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                til_password.error = "Rellena los campos correctamente"
            }




        }

        btn_create_ntrainer.setOnClickListener{
            val intent = Intent(this, CreateNewTrainer::class.java )
            startActivity(intent)
        }

    }
}