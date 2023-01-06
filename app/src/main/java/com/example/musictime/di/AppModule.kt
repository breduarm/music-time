package com.example.musictime.di

import android.content.Context
import androidx.room.Room
import com.example.musictime.data.database.db.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val DATABASE_NAME = "database-music-time"

    @Provides
    @Singleton
    fun dataBaseProvider(@ApplicationContext context: Context) = Room.databaseBuilder(context, UserDataBase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun userDaoProvider(db: UserDataBase) = db.userDao()

}