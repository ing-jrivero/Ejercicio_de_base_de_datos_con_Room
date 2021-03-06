package com.example.roomp3.Model

import androidx.room.*

@Dao
interface RegistroDao {

    @Query("SELECT * From RegistroEntity")
    fun getAllRegistros(): List<RegistroEntity>

    @Query("SELECT * From RegistroEntity WHERE email like :emailr")
    fun getRegitroById(emailr: String):RegistroEntity

    @Insert
    fun addRegistro(registro: RegistroEntity): Long

    @Update
    fun updateRegistro(registro: RegistroEntity): Int

    @Delete
    fun deleteRegistro(registro: RegistroEntity): Int






}