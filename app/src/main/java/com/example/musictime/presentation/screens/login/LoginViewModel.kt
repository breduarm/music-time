package com.example.musictime.presentation.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.domain.usecases.UserUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val userUsesCases: UserUsesCases,
    ): ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userUsesCases.authenticationUserFirebase()
            Log.i("LOGIN", "authenticationUserFirebase : $result")

        }
    }


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

    private fun isValidName(name: String): Boolean = name.length > 2

}