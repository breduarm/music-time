package com.example.musictime.domain.usecases

import com.example.musictime.domain.usecases.data_store.ReadOnBoardingPageUseCase
import com.example.musictime.domain.usecases.data_store.SaveOnBoardingPageUseCase

data class UseCases(
    val saveOnBoardingPageUseCase: SaveOnBoardingPageUseCase,
    val readOnBoardingPageUseCase: ReadOnBoardingPageUseCase
)