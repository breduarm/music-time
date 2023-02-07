package com.example.musictime.presentation.screens.signup

import androidx.lifecycle.ViewModel
import com.example.musictime.usecases.UserUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userUsesCases: UserUsesCases,
): ViewModel()  {

}