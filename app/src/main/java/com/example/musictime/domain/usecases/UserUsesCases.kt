package com.example.musictime.domain.usecases

import com.example.musictime.domain.repository.FirebaseRepository

class UserUsesCases(
    private val firebaseRepository: FirebaseRepository,
) {
    suspend fun authenticationUserFirebase() = firebaseRepository.authenticationUserFirebase()
    suspend fun loginUserFirebase(email: String, password: String) = firebaseRepository.loginUserFirebase(email, password)
}