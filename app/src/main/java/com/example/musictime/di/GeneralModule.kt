package com.example.musictime.di

import com.example.musictime.domain.repository.FirebaseRepository
import com.example.musictime.domain.usecases.UserUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class GeneralModule {

    @Provides
    fun userUseCasesProvider(firebaseRepository: FirebaseRepository): UserUsesCases =
        UserUsesCases(firebaseRepository)
}