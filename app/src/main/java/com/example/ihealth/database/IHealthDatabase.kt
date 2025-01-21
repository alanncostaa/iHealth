package com.example.ihealth.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ihealth.database.dao.DrinkDao
import com.example.ihealth.database.entities.DrinkEntity

@Database(entities = [DrinkEntity::class], version = 1)
abstract class IHealthDatabase : RoomDatabase(){
    abstract fun drinkDao(): DrinkDao

    companion object {
        fun getInstance(context: Context): IHealthDatabase {
            return Room.databaseBuilder(
                context,
                IHealthDatabase::class.java,
                "drinkHistory.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}