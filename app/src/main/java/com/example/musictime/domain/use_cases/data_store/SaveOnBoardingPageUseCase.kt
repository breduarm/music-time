package com.example.musictime.domain.use_cases.data_store

import com.example.musictime.data.repository.Repository

class SaveOnBoardingPageUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) { repository.saveOnBoardingPageState(completed) }
}