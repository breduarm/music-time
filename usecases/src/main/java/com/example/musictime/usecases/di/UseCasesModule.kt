package com.example.musictime.usecases.di

import android.content.Context
import com.example.musictime.data.repository.DataStoreOperationsImpl
import com.example.musictime.data.repository.Repository
import com.example.musictime.domain.repository.DataStoreOperations
import com.example.musictime.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    /*
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

     */


    @Provides
    @Singleton
    fun provideUseCase(
        repository: Repository
    ): UseCases =
        UseCases(
            saveOnBoardingPageUseCase = com.example.musictime.usecases.data_store.SaveOnBoardingPageUseCase(
                repository
            ),
            readOnBoardingPageUseCase = com.example.musictime.usecases.data_store.ReadOnBoardingPageUseCase(
                repository
            )
        )


}