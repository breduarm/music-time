package com.example.musictime.domain.repository

import com.example.musictime.domain.User
import com.example.musictime.domain.source.FirebaseDataSource
import com.example.musictime.domain.source.LocalDataSource
import kotlinx.coroutines.delay
import kotlin.properties.Delegates

class FirebaseRepository(
    private val firebaseDataSource: FirebaseDataSource,
    private val localDataSource: LocalDataSource
) {

    private var loginSuccess by Delegates.observable(false) { _, _, _ -> }
    private var signupSuccess by Delegates.observable(false) { _, _, _ -> }

    suspend fun authenticationUserFirebase() = firebaseDataSource.authenticationUserFirebase()

    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) : Boolean {
        val user = User(name = name, age = age, email = email, password = password)
        localDataSource.saveUser(user).run {
            firebaseDataSource.signUpUserFirebase(name, age, email, password) {
                success -> signupSuccess = success
            }
        }
        delay(3000)
        return signupSuccess
    }

    suspend fun getUserFirebase(email: String, password: String) = firebaseDataSource.getUserFirebase(email, password){ id -> loginSuccess = id }

    suspend fun loginFirebase(email: String, password: String): Boolean {
        val user = localDataSource.getUserLogged()
        val userLocalEmail = localDataSource.getUserByEmail(email)
        val userLocalPassword = localDataSource.getUserByPassword(password)
//        Log.i("FIREBASE", "user : $user")
//        Log.i("FIREBASE", "userLocalEmail : $userLocalEmail")
//        Log.i("FIREBASE", "userLocalPassword : $userLocalPassword")

        if(userLocalEmail != null && userLocalPassword != null){
            localDataSource.saveUser(User(isLogged = true))
            return true
        } else {
            getUserFirebase(email, password)
            if(user == null) localDataSource.saveUser(User(email = email, password = password))
            delay(4000)
            if(loginSuccess)
                localDataSource.saveUser(User(email = email, password = password, isLogged = true))
            return loginSuccess
        }
    }

    suspend fun getUserLogged(): User = localDataSource.getUserLogged()
    suspend fun saveUserInDB(user: User) = localDataSource.saveUser(user)
}