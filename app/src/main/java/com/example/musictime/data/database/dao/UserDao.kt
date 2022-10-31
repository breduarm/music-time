package com.example.musictime.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.musictime.data.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users where id=:id")
    suspend fun getUserById(id: String): UserEntity?

    @Query("SELECT * FROM users where email=:email")
    suspend fun getUserByEmail(email: String): UserEntity?

}