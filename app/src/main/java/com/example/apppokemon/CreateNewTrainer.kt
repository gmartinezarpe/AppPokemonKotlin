package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewDebug.FlagToString
import android.widget.Button
import android.widget.Toast
import com.example.apppokemon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout
import java.util.*

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


        val tilName_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_name)
        val tilLast_name = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_last_name)
        val tilEmail_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_email)
        val tilPassword_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_password1)
        val tilPassword_register_confirm = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_password2)



        Bottom_create.setOnClickListener{

            val Name_register = tilName_register.editText?.text
            val Last_name = tilLast_name.editText?.text
            val Email_register = tilEmail_register.editText?.text
            val Password_register = tilPassword_register.editText?.text.toString()
            val Password_register_confirm = tilPassword_register_confirm.editText?.text.toString()

            val Name_registerValid = TilValidator(tilEmail_register).required().isValid()

            val Last_nameValid = TilValidator(tilLast_name).required().isValid()

            val Email_registerValid = TilValidator(tilEmail_register).required().isValid()

            val Password_registerValid = TilValidator(tilPassword_register).required().isValid()

            val Password_register_confirmValid = TilValidator(tilPassword_register_confirm).required().isValid()

            if(Password_registerValid == Password_register_confirmValid) {

                val intent = Intent(this@CreateNewTrainer, MainActivity::class.java )
                startActivity(intent)

                Toast.makeText(this, "tu usuario a sido creado",Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "No coinciden las contraseñas",Toast.LENGTH_SHORT).show()
                  }
            }



        Bottom_cancel.setOnClickListener{
            val intent = Intent(this@CreateNewTrainer, MainActivity::class.java )
            startActivity(intent)
        }


    }
}