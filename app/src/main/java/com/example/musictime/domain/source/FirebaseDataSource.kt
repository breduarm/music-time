package com.example.musictime.domain.source

interface FirebaseDataSource {
    suspend fun authenticationUserFirebase()
    suspend fun loginUserFirebase(email: String, password: String)
}