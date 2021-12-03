package com.example.roomp3.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RegistroEntity(@PrimaryKey val email: String = "",
                     val nombre: String = "",
                     val telefono: String = "") {
}