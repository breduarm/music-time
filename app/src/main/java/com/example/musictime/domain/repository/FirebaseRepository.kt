package com.example.musictime.domain.repository

import com.example.musictime.domain.source.FirebaseDataSource

class FirebaseRepository (
    private val firebaseDataSource: FirebaseDataSource
) {
    suspend fun authenticationUserFirebase() = firebaseDataSource.authenticationUserFirebase()
    suspend fun loginUserFirebase(email: String, password: String) = firebaseDataSource.loginUserFirebase(email, password)

}