package com.example.musictime.presentation.screens.login

interface Callback<T> {
    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)
}