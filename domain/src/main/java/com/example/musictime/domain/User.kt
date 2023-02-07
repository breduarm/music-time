package com.example.musictime.domain

data class User(
    val id: String = "",
    val name: String = "",
    val age: String = "",
    val email: String = "",
    val password: String = "",
    val isLogged: Boolean = false,
    var lastInitSession: String = "",
)
