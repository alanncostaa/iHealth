package com.example.ihealth.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ihealth.database.entities.UserEntity
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE login = :login AND senha = :senha LIMIT 1")
    suspend fun getUserByLoginAndSenha(login: String, senha: String): UserEntity?

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Delete
    fun deleteUser(user: UserEntity)
}