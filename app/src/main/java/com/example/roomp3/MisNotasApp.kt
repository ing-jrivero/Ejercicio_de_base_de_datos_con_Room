package com.example.roomp3

import android.app.Application
import androidx.room.Room
import com.example.roomp3.Model.RegistroDatabase

class MisNotasApp: Application() {

    companion object{
        lateinit var database: RegistroDatabase
    }

    override fun onCreate() {
        super.onCreate()

        MisNotasApp.database = Room.databaseBuilder(this,RegistroDatabase::class.java,"Registro_db").build()

    }
}