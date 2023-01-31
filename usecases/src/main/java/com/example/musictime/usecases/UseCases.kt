package com.example.musictime.usecases

import com.example.musictime.usecases.data_store.ReadOnBoardingPageUseCase
import com.example.musictime.usecases.data_store.SaveOnBoardingPageUseCase

data class UseCases(
    val saveOnBoardingPageUseCase: SaveOnBoardingPageUseCase,
    val readOnBoardingPageUseCase: ReadOnBoardingPageUseCase
)