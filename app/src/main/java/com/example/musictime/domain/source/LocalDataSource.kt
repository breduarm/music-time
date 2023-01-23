package com.example.musictime.domain.source

import com.example.musictime.domain.Users

interface LocalDataSource {
    fun users(): List<Users>
}