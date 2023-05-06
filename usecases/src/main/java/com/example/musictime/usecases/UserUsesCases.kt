package com.example.musictime.usecases

import com.example.musictime.usecases.data_store.ReadOnBoardingPageUseCase
import com.example.musictime.usecases.data_store.SaveOnBoardingPageUseCase

data class UserUsesCases(
    val saveOnBoardingPageUseCase: SaveOnBoardingPageUseCase,
    val readOnBoardingPageUseCase: ReadOnBoardingPageUseCase
)