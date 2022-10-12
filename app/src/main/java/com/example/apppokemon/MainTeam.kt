package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.textfield.TextInputLayout

class MainTeam : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_team)


        val eliminar_uno = findViewById<ImageButton>(R.id.eliminar_uno)
        val actualizar_uno = findViewById<ImageButton>(R.id.actualizar_uno)

        eliminar_uno.setOnClickListener{
            val intent = Intent(this, DeleteActivity::class.java )
            startActivity(intent)
        }

        actualizar_uno.setOnClickListener{
            val intent = Intent(this, UpdataActivity::class.java )
            startActivity(intent)
        }


    }




}