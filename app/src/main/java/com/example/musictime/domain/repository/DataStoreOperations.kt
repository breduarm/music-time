package com.example.musictime.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnBoardingPageState(completed: Boolean)
    fun readOnBoardingPageState(): Flow<Boolean>
}