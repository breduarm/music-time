package com.example.musictime.navigation.navgraph

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.usecases.AuthenticationUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthNavViewModel @Inject constructor(
    private val authenticationUsesCases: AuthenticationUsesCases
): ViewModel() {
    var isLogged by mutableStateOf(-1)
        private set

   init {
       viewModelScope.launch(Dispatchers.Main) {
           val user = authenticationUsesCases.getUserLogged()
           isLogged = if(user.isLogged) 0 else 1
       }
    }
}