package com.example.musictime.data

import com.example.musictime.data.database.entity.UserEntity
import com.example.musictime.domain.Users

fun List<UserEntity>.toDomainModel(): List<Users> = map { it.toDomainModel() }
fun UserEntity.toDomainModel(): Users = Users(
    id, name, email

)