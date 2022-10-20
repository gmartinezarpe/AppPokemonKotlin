package roomDataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import roomDataBase.identity.Usuario

@Dao
interface DaoUsuario {

    @Query("SELECT * FROM Usuario")
    //metodo para obtener info
    suspend fun obtenerUsuario(): List<Usuario>

    @Query(" SELECT * FROM  Usuario WHERE usuario=:usuario")
    suspend fun obtenerUsuario(usuario: String):Usuario

    @Query(" SELECT * FROM  Usuario WHERE usuario=:usuario AND contrasena=:contrasena")
    suspend fun Login(usuario: String, contrasena: String):List<Usuario>

    @Insert
    suspend fun agregarUsuario(usuario: Usuario):Long

    @Query("UPDATE Usuario SET nombre=:nombre, contrasena=:contrasena WHERE usuario=:usuario")
    suspend fun  actualizarUsuario(nombre:String, usuario:String, contrasena:String):Int

    @Query("DELETE FROM Usuario WHERE usuario=:usuario")
    suspend fun borrarUsuario(usuario: String)
}