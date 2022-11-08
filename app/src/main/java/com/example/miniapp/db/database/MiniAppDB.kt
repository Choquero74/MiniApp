package com.example.miniapp.db.database

/**
 * Base de datos de la aplicación Pets Lover.
 * La clase de base de datos debe cumplir las siguientes condiciones:
 * 1. Debe ir precedida de la anotación @Database.
 * 2. Debe ser abstracta que extienda la interfaz RoomDatabase.
 * 3. Debe ser una clase singleton para evitar que se abran varias instancias de la base de datos al mismo tiempo.
 * 4. Debe contener un método abstracto que devuelve un objeto DAO, para cada entidad.
 * @author Choquero
 * @version 1, 2022/10
 */

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.miniapp.db.dao.TypeDao
import com.example.miniapp.db.entity.TypeEntity

@Database (
    entities = [TypeEntity::class],
    version = 1,
    exportSchema = false
    )
abstract class MiniAppDB: RoomDatabase() {

    // Método abstracto que devuelve un objeto DAO, para cada entidad.
    abstract fun typeDao(): TypeDao

    companion object {
        // Singleton evita que se abran varias instancias de la base de datos al mismo tiempo.
        @Volatile
        private var INSTANCE: MiniAppDB? = null

        fun getDatabase(
            context: Context,
        ): MiniAppDB {
            // Si la INSTANCIA no es nula, la devuelve, si lo es, crea la base de datos.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MiniAppDB::class.java,
                    "application_database"
                )

                    .build()
                INSTANCE = instance
                // Instancia de retorno.
                instance
            }
        }
    }
}