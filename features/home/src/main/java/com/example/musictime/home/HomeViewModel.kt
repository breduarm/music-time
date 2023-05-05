package com.example.musictime.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.domain.User
import com.example.musictime.usecases.UserUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userUsesCases: UserUsesCases,
): ViewModel()  {
    var name by mutableStateOf("User")
        private set

    var email by mutableStateOf("Email")
        private set

    private lateinit var user: User

    init {
        viewModelScope.launch(Dispatchers.Main) {
            user = userUsesCases.getUserLogged()
            Log.i("FIREBASE", "HomeViewModel - user : $user")
            if(user.name.isNotEmpty()) name = user.name
            if(user.email.isNotEmpty()) email = user.email
        }
    }

    fun onLogout(){
        Log.i("FIREBASE", "log out")
        Log.i("FIREBASE", "onLogout : $user")
        user.isLogged = false
        viewModelScope.launch(Dispatchers.Main) {  userUsesCases.saveUserInDB(user) }
    }
}