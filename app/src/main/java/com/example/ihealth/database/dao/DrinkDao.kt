package com.example.ihealth.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ihealth.database.entities.DrinkEntity
import com.example.ihealth.model.Drink

@Dao
interface DrikDao {
    @Query("SELECT * FROM DrinkEntity")
    fun findAll(): List<Drink>

    @Insert
    suspend fun save(drink: DrinkEntity)
}