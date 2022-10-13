package com.example.apppokemon.controllers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.apppokemon.HomeLayout

class AuthController constructor(ctx: Context) {
    private val ctx = ctx

    fun login(email: String, password: String){
        if(email == "asd@asd.cl" && password == "qwerty") {
            Toast.makeText(this.ctx, "Bienvenido Entrenador", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, HomeLayout::class.java)
            this.ctx.startActivity(intent)
        }else{
            Toast.makeText(this.ctx, "Credenciales Invalidas", Toast.LENGTH_SHORT).show()
        }

    }
}