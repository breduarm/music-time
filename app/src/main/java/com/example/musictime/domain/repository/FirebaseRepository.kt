package com.example.musictime.domain.repository

import android.util.Log
import com.example.musictime.domain.User
import com.example.musictime.domain.source.FirebaseDataSource
import com.example.musictime.domain.source.LocalDataSource

class FirebaseRepository(
    private val firebaseDataSource: FirebaseDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun authenticationUserFirebase() = firebaseDataSource.authenticationUserFirebase()
    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) {
        val user = User(
            name = name,
            age = age,
            email = email,
            password = password
        )
        val userSave = localDataSource.saveUser(user).run {
            firebaseDataSource.signUpUserFirebase(name, age, email, password)
        }
        Log.i("FIREBASE", "saveUser : $userSave")

    }


    suspend fun getUserFirebase(email: String, password: String) =
        firebaseDataSource.getUserFirebase(email, password)

    suspend fun loginFirebase(email: String, password: String): Boolean {
        val userLocalEmail = localDataSource.getUserByEmail(email)
        val userLocalPassword = localDataSource.getUserByPassword(password)

        Log.i("FIREBASE", "userLocalEmail : $userLocalEmail")
        Log.i("FIREBASE", "userLocalPassword : $userLocalPassword")

        /*
            userLocal?.let { saveUserDB(it.apply {
                it.token = userResponse.result!!.token
                it.biometricId = userResponse.result!!.biometricId
                it.emailVerificationIsVerified = userResponse.result!!.emailVerificationIsVerified
            })
            } ?: run { saveUserDB(userResponse.result!!) }
            localDataSource.setUserLogged(userResponse.result!!.id)

         */


        return true

    }
}