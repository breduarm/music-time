package com.example.musictime.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.musictime.data.repository.DataStoreOperationsImpl
import com.example.musictime.data.repository.Repository
import com.example.musictime.domain.repository.DataStoreOperations
import com.example.musictime.domain.usecases.UseCases
import com.example.musictime.domain.usecases.data_store.ReadOnBoardingPageUseCase
import com.example.musictime.domain.usecases.data_store.SaveOnBoardingPageUseCase
import com.example.musictime.util.Constants.PREFERENCE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = PreferenceDataStoreFactory.create(produceFile = {
        context.preferencesDataStoreFile(PREFERENCE_NAME)
    })

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperations = DataStoreOperationsImpl(dataStore = dataStore)

    @Provides
    @Singleton
    fun provideUseCase(
        repository: Repository
    ): UseCases =
        UseCases(
            saveOnBoardingPageUseCase = SaveOnBoardingPageUseCase(repository),
            readOnBoardingPageUseCase = ReadOnBoardingPageUseCase(repository)
        )
}