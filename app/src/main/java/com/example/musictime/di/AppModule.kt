package com.example.musictime.di

import android.content.Context
import androidx.room.Room
import com.example.musictime.data.database.db.UserDataBase
import com.example.musictime.data.server.firebase.FirebaseServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun dataBaseProvider(@ApplicationContext context: Context) = Room.databaseBuilder(context, UserDataBase::class.java, "database-music-time").build()

    @Provides
    @Singleton
    fun userDaoProvider(db: UserDataBase) = db.userDao()

    @Provides
    fun firebaseServicesProvider(): FirebaseServices = FirebaseServices()

}