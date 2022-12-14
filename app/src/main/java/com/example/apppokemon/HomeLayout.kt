package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_layout)

        val btn_tv_pokedex = findViewById<TextView>(R.id.act_home_layout_tv_pokedex)
        val btn_tv_teams = findViewById<TextView>(R.id.act_home_layout_tv_teams)

        btn_tv_pokedex.setOnClickListener {
            val intent = Intent(this, DexLayout::class.java)
            startActivity(intent)
        }

        btn_tv_teams.setOnClickListener {
            val intent = Intent(this, grid_view_items::class.java)
            startActivity(intent)
        }


    }
}