package com.example.musictime.domain.repository

import com.example.musictime.domain.source.AuthenticationRemoteDataSource
import com.example.musictime.domain.source.LocalDataSource

class AuthenticationRepository(
    private val firebaseRepository: FirebaseRepository,
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun authenticationUserFirebase() = firebaseRepository.authenticationUserFirebase()
    suspend fun loginUserFirebase(email: String, password: String): Any = firebaseRepository.loginUserFirebase(email, password)
}