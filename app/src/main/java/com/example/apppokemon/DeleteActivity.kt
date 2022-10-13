package com.example.apppokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        val btn_eliminar = findViewById<Button>(R.id.act_delete_btn_eliminar)

        btn_eliminar.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Prueba de Eliminacion")
            builder.setMessage("¿Esta seguro que quiere eliminar el elemento seleccionado?")
            builder.setPositiveButton("Eliminar") {
                dialog,
                    witch ->
                Toast.makeText(this,"IT'S GONE",Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("cancelar", null)
            builder.setNeutralButton("No estoy seguro", null)
            builder.show()
        }
    }
}