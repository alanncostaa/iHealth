package com.example.ihealth.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ihealth.database.dao.DrinkDao
import com.example.ihealth.database.dao.UserDao
import com.example.ihealth.database.entities.DrinkEntity
import com.example.ihealth.database.entities.UserEntity

@Database(entities = [DrinkEntity::class, UserEntity::class], version = 2)
abstract class IHealthDatabase : RoomDatabase() {
    abstract fun drinkDao(): DrinkDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: IHealthDatabase? = null

        fun getInstance(context: Context): IHealthDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IHealthDatabase::class.java,
                    "ihealth.db"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
