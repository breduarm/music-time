package com.example.musictime.usecases

import com.example.musictime.domain.User
import com.example.musictime.domain.repository.FirebaseRepository

class AuthenticationUsesCases(
    private val firebaseRepository: FirebaseRepository,
) {
    suspend fun authenticationUserFirebase() = firebaseRepository.authenticationUserFirebase()
    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) = firebaseRepository.signUpUserFirebase(name, age, email, password)
    suspend fun getUserFirebase(email: String, password: String) = firebaseRepository.getUserFirebase(email, password)
    suspend fun loginFirebase(email: String, password: String) = firebaseRepository.loginFirebase(email, password)
    suspend fun getUserLogged(): User = firebaseRepository.getUserLogged()
    suspend fun saveUserInDB(user: User) = firebaseRepository.saveUserInDB(user)
}