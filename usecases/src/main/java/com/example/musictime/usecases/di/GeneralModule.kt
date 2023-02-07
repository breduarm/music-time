package com.example.musictime.data.di

import com.example.musictime.domain.repository.FirebaseRepository
import com.example.musictime.usecases.UserUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class GeneralModule {

    @Provides
    fun userUseCasesProvider(firebaseRepository: FirebaseRepository): com.example.musictime.usecases.UserUsesCases =
        com.example.musictime.usecases.UserUsesCases(firebaseRepository)
}