package com.example.musictime.domain.source

interface FirebaseDataSource {
    suspend fun authenticationUserFirebase()
    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String)
    suspend fun getUserFirebase(email: String, password: String, callback: (Boolean)->Unit) 
    suspend fun loginFirebase(email: String, password: String)
}