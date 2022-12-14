package com.example.musictime.presentation.screens.splash

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.domain.use_cases.UseCases
import com.example.musictime.navigation.navgraph.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    var isLoading by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Graph.WELCOME)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.readOnBoardingPageUseCase().collect { completed ->
                startDestination = if (completed) Graph.AUTH else Graph.WELCOME
            }
            isLoading = false
        }
    }

}