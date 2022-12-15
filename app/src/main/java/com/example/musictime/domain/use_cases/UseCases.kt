package com.example.musictime.domain.use_cases

import com.example.musictime.domain.use_cases.data_store.ReadOnBoardingPageUseCase
import com.example.musictime.domain.use_cases.data_store.SaveOnBoardingPageUseCase

data class UseCases(
    val saveOnBoardingPageUseCase: SaveOnBoardingPageUseCase,
    val readOnBoardingPageUseCase: ReadOnBoardingPageUseCase
)