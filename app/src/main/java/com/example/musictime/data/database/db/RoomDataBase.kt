package com.example.musictime.data.database.db

import com.example.musictime.data.database.dao.UserDao
import com.example.musictime.data.toDomainModel
import com.example.musictime.domain.Users
import com.example.musictime.domain.source.LocalDataSource
import javax.inject.Inject

class RoomDataBase @Inject constructor(
    private val userDao: UserDao
) : LocalDataSource {
    override fun users(): List<Users> = userDao.getAll().toDomainModel()

}