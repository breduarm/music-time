package com.example.musictime.data.repository

import com.example.musictime.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreOperations: DataStoreOperations
) {
    suspend fun saveOnBoardingPageState(completed: Boolean) { dataStoreOperations.saveOnBoardingPageState(completed) }
    fun readOnBoardingPageState(): Flow<Boolean> = dataStoreOperations.readOnBoardingPageState()
}