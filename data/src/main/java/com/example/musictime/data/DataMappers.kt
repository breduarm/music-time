package com.example.musictime.data

import com.example.musictime.data.database.entity.UserEntity
import com.example.musictime.domain.User

fun List<UserEntity>.toDomainModel(): List<User> = map { it.toDomainModel() }

fun UserEntity.toDomainModel(): User = User(
    id = id,
    name = name,
    age = age,
    email = email,
    password = password,
    isLogged = isLogged,
    lastInitSession = lastInitSession
)

fun User.toEntityDB(): UserEntity = UserEntity(
    id = id,
    name = name,
    age = age,
    email = email,
    password = password,
    isLogged = isLogged,
    lastInitSession = lastInitSession
)