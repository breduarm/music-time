package com.example.musictime.domain.source

interface AuthenticationRemoteDataSource {
    suspend fun authenticationUserFirebase()
    suspend fun loginUserFirebase(email: String, password: String): Any
}