package roomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import roomDataBase.dao.DaoUsuario
import roomDataBase.identity.Usuario

@Database(
    entities = [Usuario::class],
    version = 1
)

abstract class DB:RoomDatabase(){
    abstract fun daoUsuario():DaoUsuario

}
