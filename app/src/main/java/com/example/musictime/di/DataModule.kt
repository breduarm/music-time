package com.example.musictime.di

import com.example.musictime.data.database.db.RoomDataBase
import com.example.musictime.data.server.firebase.FirebaseServices
import com.example.musictime.domain.repository.AuthenticationRepository
import com.example.musictime.domain.repository.FirebaseRepository
import com.example.musictime.domain.source.AuthenticationRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun firebaseRepositoryProvider(
        firebaseServices: FirebaseServices
    ) = FirebaseRepository(firebaseServices)

    @Provides
    fun authenticationRepositoryProvider(
        firebaseRepository: FirebaseRepository,
        authenticationRemoteDataSource: AuthenticationRemoteDataSource,
        localDataBase: RoomDataBase,
    ) = AuthenticationRepository(firebaseRepository, authenticationRemoteDataSource, localDataBase)

}