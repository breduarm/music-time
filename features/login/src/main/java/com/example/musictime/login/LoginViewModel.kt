package com.example.musictime.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.usecases.AuthenticationUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val authenticationUsesCases: AuthenticationUsesCases,
    ): ViewModel() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _age = MutableLiveData<String>()
    val age : LiveData<String> = _age

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled : LiveData<Boolean> = _loginEnabled

    private val _signUpEnabled = MutableLiveData<Boolean>()
    val signUpEnabled : LiveData<Boolean> = _signUpEnabled

    private val _loginSuccess = MutableLiveData<Int>()
    val loginSuccess : LiveData<Int> = _loginSuccess

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length >= 6

    fun requestLogin() {
        _showProgress.value = true
        _loginEnabled.value = false
        viewModelScope.launch(Dispatchers.IO) {
            val result = authenticationUsesCases.loginFirebase(_email.value!!, _password.value!!)
            Log.i("FIREBASE", "loginFirebase : $result")
            if(result) _loginSuccess.postValue(0)
            else {
                _showProgress.postValue(false)
                _loginEnabled.postValue(true)
                _loginSuccess.postValue(1)
            }

        }
        //_loginSuccess.postValue(-1)
    }
}