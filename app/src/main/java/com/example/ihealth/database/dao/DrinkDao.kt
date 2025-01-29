package com.example.ihealth.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ihealth.database.entities.DrinkEntity

@Dao
interface DrinkDao {
    @Query("SELECT * FROM DrinkEntity")
    suspend fun findAll(): List<DrinkEntity>

    @Insert
    fun save(drink: DrinkEntity)

    @Delete
    fun delete(drink: DrinkEntity)
}