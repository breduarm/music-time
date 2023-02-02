package com.example.musictime.usecases.data_store

import com.example.musictime.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingPageUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> = repository.readOnBoardingPageState()
}