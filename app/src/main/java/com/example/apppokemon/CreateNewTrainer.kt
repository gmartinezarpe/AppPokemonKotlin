package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class CreateNewTrainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_trainer)

        val Bottom_create = findViewById<Button>(R.id.act_new_trainer_btn_new_login)
        val Bottom_cancel = findViewById<Button>(R.id.act_new_trainer_btn_cancel)


        Bottom_create.setOnClickListener{
            val intent = Intent(this@CreateNewTrainer, MainActivity::class.java )
            startActivity(intent)
        }

        Bottom_cancel.setOnClickListener{
            val intent = Intent(this@CreateNewTrainer, MainActivity::class.java )
            startActivity(intent)
        }


        val Name_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_name)
        val Last_name = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_last_name)
        val Email_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_email)
        val Password_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_password1)
        val Password_register_confirm = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_password2)

    }
}