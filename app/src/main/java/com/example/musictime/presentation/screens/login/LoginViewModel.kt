package com.example.musictime.presentation.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled : LiveData<Boolean> = _loginEnabled

    fun onLoginChanged(name: String, password: String) {
        _name.value = name
        _password.value = password
        _loginEnabled.value = isValidName(name) /** && isValidPassword(password) */
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidName(name: String): Boolean = name.length > 6

}