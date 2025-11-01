package com.example.agendacontatos.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.agendacontatos.model.Usuario

@Dao
interface UsuarioDAO {
    @Insert
    fun inserir(listaUsuarios: MutableList<Usuario>)
}