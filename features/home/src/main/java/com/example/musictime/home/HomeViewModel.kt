package com.example.musictime.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.usecases.UserUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userUsesCases: UserUsesCases,

): ViewModel()  {


    var name by mutableStateOf(""); private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userUsesCases.getUserLogged()
            Log.i("FIREBASE", "HomeViewModel - user : $user")
        }
    }

}