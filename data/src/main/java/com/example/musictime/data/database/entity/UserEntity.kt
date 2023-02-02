package com.example.musictime.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey
    val id: Int,
    val email: String,
    val token: String
)