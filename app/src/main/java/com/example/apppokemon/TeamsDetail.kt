package com.example.apppokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class TeamsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams_detail)

        val detail_delete_one = findViewById<ImageButton>(R.id.act_detail_iv_delete_one)
        val detail_update_one = findViewById<ImageButton>(R.id.act_detail_iv_update_one)

        detail_delete_one.setOnClickListener{
            val intent = Intent(this, DeleteActivity::class.java )
            startActivity(intent)
        }

        detail_update_one.setOnClickListener{
            val intent = Intent(this, UpdataActivity::class.java )
            startActivity(intent)
        }
    }
}