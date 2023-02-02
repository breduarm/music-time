package com.example.musictime.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musictime.data.database.dao.UserDao
import com.example.musictime.data.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
}