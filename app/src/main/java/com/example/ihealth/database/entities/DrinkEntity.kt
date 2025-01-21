package com.example.ihealth.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class DrinkEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val quantidade: Int,
    val tipo: String,
    val data: String,
    val hora: String
)