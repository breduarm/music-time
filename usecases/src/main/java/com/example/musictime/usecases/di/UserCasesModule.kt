package com.example.musictime.usecases.di

import com.example.musictime.data.repository.Repository
import com.example.musictime.usecases.UserUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserCasesModule {

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
    ): UserUsesCases =
        UserUsesCases(
            saveOnBoardingPageUseCase = com.example.musictime.usecases.data_store.SaveOnBoardingPageUseCase(
                repository
            ),
            readOnBoardingPageUseCase = com.example.musictime.usecases.data_store.ReadOnBoardingPageUseCase(
                repository
            )
        )


}