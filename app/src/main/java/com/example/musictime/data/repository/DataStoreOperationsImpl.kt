package com.example.musictime.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.musictime.domain.repository.DataStoreOperations
import com.example.musictime.util.Constants.PREFERENCES_ON_BOARDING_PAGE_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStoreOperationsImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): DataStoreOperations {

    private object PreferencesKey {
        val onBoardingPageKey = booleanPreferencesKey(name = PREFERENCES_ON_BOARDING_PAGE_KEY)
    }
    override suspend fun saveOnBoardingPageState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingPageKey] = completed
        }
    }

    override fun readOnBoardingPageState(): Flow<Boolean> {
        return dataStore
            .data
            .catch {
                if (it is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { preferences ->
                preferences[PreferencesKey.onBoardingPageKey] ?: false
            }
    }

}