package com.example.musictime.splash

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.core.Graph
import com.example.musictime.usecases.UserUsesCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val userUsesCases: UserUsesCases
): ViewModel() {

    var isLoading by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Graph.WELCOME)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userUsesCases.readOnBoardingPageUseCase().collect { completed -> startDestination = if (completed) Graph.AUTH else Graph.WELCOME }
            isLoading = false
        }
    }

}