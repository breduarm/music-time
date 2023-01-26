package com.example.musictime.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey
    val id: String,
    val name: String = "",
    val age: String = "",
    val email: String = "",
    val password: String = "",
    val isLogged: Boolean = false,
    var lastInitSession: String = "",
) : Parcelable