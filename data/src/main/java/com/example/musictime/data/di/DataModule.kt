package com.example.musictime.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.musictime.data.database.dao.UserDao
import com.example.musictime.data.database.db.RoomDataBase
import com.example.musictime.data.database.db.UserDataBase
import com.example.musictime.data.repository.DataStoreOperationsImpl
import com.example.musictime.data.server.firebase.FirebaseServices
import com.example.musictime.domain.repository.DataStoreOperations
import com.example.musictime.domain.repository.FirebaseRepository
import com.example.musictime.domain.source.LocalDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

     private const val DATABASE_NAME = "database-music-time"

     @Provides
     @Singleton
     fun firebaseRepositoryProvider(firebaseServices: FirebaseServices, localDataSource: LocalDataSource) = FirebaseRepository(firebaseServices,localDataSource)


    @Provides
    @Singleton
    fun dataBaseProvider(@ApplicationContext context: Context) = Room.databaseBuilder(context, UserDataBase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun userDaoProvider(db: UserDataBase) = db.userDao()

    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = PreferenceDataStoreFactory.create(produceFile = {
        context.preferencesDataStoreFile("music_time_preferences")//PREFERENCE_NAME
    })

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperations = DataStoreOperationsImpl(dataStore = dataStore)

     @Provides
     fun firebaseServicesProvider(): FirebaseServices = FirebaseServices()

     @Provides
     fun localDataSource(userDao: UserDao): LocalDataSource = RoomDataBase(userDao)


}