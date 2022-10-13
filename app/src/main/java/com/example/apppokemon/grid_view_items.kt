package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class grid_view_items : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_items)

        val Contrain_TeamUno = findViewById<ConstraintLayout>(R.id.Contrain_TeamUno)

        Contrain_TeamUno.setOnClickListener{
            val intent = Intent(this, TeamsDetail::class.java )
            startActivity(intent)
        }


    }


}