package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewDebug.FlagToString
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.apppokemon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import roomDataBase.DB
import roomDataBase.identity.Usuario
import java.util.*

class CreateNewTrainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_trainer)

        val Bottom_create = findViewById<Button>(R.id.act_new_trainer_btn_new_login)
        val Bottom_cancel = findViewById<Button>(R.id.act_new_trainer_btn_cancel)



        //inicializar la base de datos
       val room = Room.databaseBuilder(this, DB::class.java,"database-hola").allowMainThreadQueries().build()



        val tilName_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_name)
        val tilLast_name = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_last_name)
        val tilEmail_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_email)
        val tilPassword_register = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_password1)
        val tilPassword_register_confirm = findViewById<TextInputLayout>(R.id.act_new_trainer_tv_password2)
        val tilspnGender = findViewById<Spinner>(R.id.activity_register_spn_gender)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.genders_array,
            android.R.layout.simple_spinner_item

        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            tilspnGender.adapter = adapter



        Bottom_create.setOnClickListener{

            val Name_register = tilName_register.editText?.text.toString()
            val Last_name = tilLast_name.editText?.text.toString()
            val spinner_gender = tilspnGender.selectedItem.toString()
            val Email_register = tilEmail_register.editText?.text.toString()
            val Password_register = tilPassword_register.editText?.text.toString()
            val Password_register_confirm = tilPassword_register_confirm.editText?.text.toString()







            val Name_registerValid = TilValidator(tilName_register).required().isValid()

            val Last_nameValid = TilValidator(tilLast_name).required().isValid()

            val Email_registerValid = TilValidator(tilEmail_register).required().email().isValid()

            val Password_registerValid = TilValidator(tilPassword_register).required().isValid()

            val Password_register_confirmValid = TilValidator(tilPassword_register_confirm).required().isValid()



            // Validaci??n completa

            if(Name_registerValid && Last_nameValid && Email_registerValid &&
                Password_registerValid && Password_register_confirmValid) {
                if(Password_register == Password_register_confirm) {
                    if(Password_register != null &&  Password_register_confirm != null ) {

                        val usuario = Usuario(Name_register,Email_register,Password_register,Last_name)
                        lifecycleScope.launch{
                            val id = room.daoUsuario().agregarUsuario(usuario)
                            if(id>0){
                                Log.i( "Log_insert_USER", id.toString())
                                Toast.makeText(this@CreateNewTrainer, "usuario registrado exitosamente", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@CreateNewTrainer, MainActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this@CreateNewTrainer, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show()
                            }

                        }


                    }else{
                        Toast.makeText(this, "Debe ingresar una contrase??a", Toast.LENGTH_SHORT).show()

                    }

                } else {
                    Toast.makeText(this, "Las contrase??as no coinciden", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Existen campos sin rellenar", Toast.LENGTH_SHORT).show()
            }







        }
        Bottom_cancel.setOnClickListener{
            val intent = Intent(this@CreateNewTrainer, MainActivity::class.java )
            startActivity(intent)
        }
    }
}