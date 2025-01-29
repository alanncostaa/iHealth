package com.example.ihealth.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val login: String,
    val senha: String,
    val email: String,

    //nomes
    val nome: String,
    val sobrenome: String,

    //valores
    val sexo: String,
    val peso: String,
    val altura: String,
    val idade: String,
)
