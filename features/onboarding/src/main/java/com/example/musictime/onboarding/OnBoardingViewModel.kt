package com.example.musictime.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.usecases.UserUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userUsesCases: UserUsesCases
): ViewModel() {

    fun saveOnBoardingPageState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            userUsesCases.saveOnBoardingPageUseCase(completed = completed)
        }
    }
}