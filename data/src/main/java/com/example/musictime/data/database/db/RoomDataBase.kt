package com.example.musictime.data.database.db

import android.util.Log
import com.example.musictime.data.database.dao.UserDao
import com.example.musictime.data.toDomainModel
import com.example.musictime.data.toEntityDB
import com.example.musictime.domain.User
import com.example.musictime.domain.source.LocalDataSource
import javax.inject.Inject
import java.text.SimpleDateFormat
import java.util.*

class RoomDataBase @Inject constructor(
    private val userDao: UserDao
) : LocalDataSource {

    override fun users(): List<User> = userDao.getAll().toDomainModel()

    override suspend fun saveUser(user: User): Boolean {
        return try {
            userDao.insertUser(user.toEntityDB())
            return true
        } catch (e: Exception) {
            Log.i("FIREBASE", "error db: ${e.message}")
            return false
        }
    }

    override fun deleteUser(user: User) = userDao.deleteUser(user.toEntityDB())

    override suspend fun getUserLogged(): User {
        return userDao.getUserLogged()?.toDomainModel() ?: User(id = "", name = "", age = "", password = "", email = "", isLogged = false)
    }

    override suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomainModel()
    }

    override suspend fun getUserByPassword(password: String): User? {
        return userDao.getUserByPassword(password)?.toDomainModel()
    }

    override suspend fun saveLastVisitDate() {
        val user = getUserLogged()
        user?.let {
            it.lastInitSession = SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                Locale.getDefault()
            ).format(Calendar.getInstance().time)

            userDao.insertUser(it.toEntityDB())
        }
    }

}