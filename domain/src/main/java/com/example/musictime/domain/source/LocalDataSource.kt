package com.example.musictime.domain.source

import com.example.musictime.domain.User
import com.example.musictime.domain.Result

interface LocalDataSource {
    fun users(): List<User>
    suspend fun saveUser(user: User): Boolean
    fun deleteUser(user: User)
    suspend fun getUserLogged():User?
    suspend fun getUserByEmail(email: String) : User?
    suspend fun getUserByPassword(password: String) : User?
    suspend fun saveLastVisitDate()
}