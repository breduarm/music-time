package com.example.musictime.domain.repository

import com.example.musictime.domain.source.FirebaseDataSource

class FirebaseRepository (
    private val firebaseDataSource: FirebaseDataSource
) {
    suspend fun authenticationUserFirebase() = firebaseDataSource.authenticationUserFirebase()
    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) = firebaseDataSource.signUpUserFirebase(name, age, email, password)
    suspend fun getUserFirebase(email: String, password: String) = firebaseDataSource.getUserFirebase(email, password)
}