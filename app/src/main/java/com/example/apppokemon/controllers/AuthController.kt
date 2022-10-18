package com.example.apppokemon.controllers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.apppokemon.HomeLayout
import com.example.apppokemon.MainActivity

class AuthController constructor(ctx: Context) {
    private val ctx = ctx

    fun login(email: String, password: String){
        if(email == "profesor" && password == "1234") {
            Toast.makeText(this.ctx, "Bienvenido Entrenador", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, HomeLayout::class.java)
            this.ctx.startActivity(intent)
        }else{
            Toast.makeText(this.ctx, "Credenciales Invalidas", Toast.LENGTH_SHORT).show()
        }
    }
    fun register(name: String,lastName: String, email: String, password: String, passwordConfirm: String){
        Toast.makeText(this.ctx, "usuario registrado", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, MainActivity::class.java)
        this.ctx.startActivity(intent)
    }
}