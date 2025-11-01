package com.example.agendacontatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agendacontatos.dao.UsuarioDAO
import com.example.agendacontatos.model.Usuario
import kotlin.concurrent.Volatile

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDAO

    companion object {
        private const val DATABASE_NOME = "DB_USUARIOS"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NOME
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}