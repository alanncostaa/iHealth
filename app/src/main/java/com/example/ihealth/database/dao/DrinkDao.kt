package com.example.ihealth.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ihealth.database.entities.DrinkEntity
import com.example.ihealth.model.Drink

@Dao
interface DrinkDao {
    @Query("SELECT * FROM DrinkEntity")
    fun findAll(): List<DrinkEntity>

    @Insert
    fun save(drink: DrinkEntity)

    @Delete
    fun delete(drink: DrinkEntity)
}