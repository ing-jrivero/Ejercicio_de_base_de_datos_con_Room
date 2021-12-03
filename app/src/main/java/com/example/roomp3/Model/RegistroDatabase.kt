package com.example.roomp3.Model

import androidx.room.Database
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RegistroEntity::class),version = 1)
abstract class RegistroDatabase():RoomDatabase() {

    abstract fun registroDao(): RegistroDao
}