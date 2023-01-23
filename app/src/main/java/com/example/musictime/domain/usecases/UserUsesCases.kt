package com.example.musictime.domain.usecases

import com.example.musictime.domain.repository.FirebaseRepository

class UserUsesCases(
    private val firebaseRepository: FirebaseRepository,
) {
    suspend fun authenticationUserFirebase() = firebaseRepository.authenticationUserFirebase()
    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) = firebaseRepository.signUpUserFirebase(name, age, email, password)
    suspend fun getUserFirebase(email: String, password: String) = firebaseRepository.getUserFirebase(email, password)
}