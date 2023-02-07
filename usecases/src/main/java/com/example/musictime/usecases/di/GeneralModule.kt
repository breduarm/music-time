package com.example.musictime.usecases.di

import com.example.musictime.domain.repository.FirebaseRepository
import com.example.musictime.usecases.UserUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GeneralModule {

    @Provides
    fun userUseCasesProvider(firebaseRepository: FirebaseRepository): UserUsesCases = UserUsesCases(firebaseRepository)
}