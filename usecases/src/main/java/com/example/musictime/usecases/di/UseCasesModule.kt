package com.example.musictime.usecases.di

import com.example.musictime.data.repository.Repository
import com.example.musictime.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
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