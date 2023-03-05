package com.example.musictime.domain.repository

import android.util.Log
import com.example.musictime.domain.User
import com.example.musictime.domain.source.FirebaseDataSource
import com.example.musictime.domain.source.LocalDataSource
import kotlinx.coroutines.delay
import kotlin.properties.Delegates

class FirebaseRepository(
    private val firebaseDataSource: FirebaseDataSource,
    private val localDataSource: LocalDataSource
) {

   private var loginSuccess by Delegates.observable(false) { property, oldValue, newValue ->
         //Log.d("FIREBASE","New Value $newValue")
         //Log.d("FIREBASE","Old Value $oldValue")
    }

    private var signupSuccess by Delegates.observable(false) { property, oldValue, newValue ->
        //Log.d("FIREBASE","New Value $newValue")
        //Log.d("FIREBASE","Old Value $oldValue")
    }

    suspend fun authenticationUserFirebase() = firebaseDataSource.authenticationUserFirebase()

    suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) : Boolean {
        val user = User(name = name, age = age, email = email, password = password)
                success -> signupSuccess = success
                Log.i("FIREBASE", "saveUser -> success : $success")
            }
        }
        delay(3000)
        return signupSuccess
    }


    suspend fun getUserFirebase(email: String, password: String) = firebaseDataSource.getUserFirebase(email, password){ id ->
        Log.i("FIREBASE", "id : $id")
        loginSuccess = id
    }

    suspend fun loginFirebase(email: String, password: String): Boolean {
        val userLocalEmail = localDataSource.getUserByEmail(email)
        val userLocalPassword = localDataSource.getUserByPassword(password)

        Log.i("FIREBASE", "userLocalEmail : $userLocalEmail")
        Log.i("FIREBASE", "userLocalPassword : $userLocalPassword")

        if(userLocalEmail != null && userLocalPassword != null){
            return true
        } else {
            getUserFirebase(email, password)
            delay(3000)
            return loginSuccess
        }

    }
}