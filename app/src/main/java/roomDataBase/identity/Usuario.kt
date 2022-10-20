package roomDataBase.identity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario {
    @PrimaryKey
    var usuario: String
    var nombre: String? = null
    var contrasena : String? = null
    var apellido : String

    constructor(nombre:String, usuario:String, contrasena: String, apellido: String){
        this.usuario = usuario
        this.nombre = nombre
        this.apellido = apellido
        this.contrasena= contrasena

    }


}