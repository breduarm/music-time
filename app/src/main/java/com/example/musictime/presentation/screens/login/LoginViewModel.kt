package com.example.musictime.presentation.screens.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictime.domain.usecases.UserUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val userUsesCases: UserUsesCases,
    ): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled : LiveData<Boolean> = _loginEnabled

    private val _signUpEnabled = MutableLiveData<Boolean>()
    val signUpEnabled : LiveData<Boolean> = _signUpEnabled

    private val _signUpClick = MutableLiveData<Boolean>()
    val signUpClick : LiveData<Boolean> = _signUpClick

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _age = MutableLiveData<String>()
    val age : LiveData<String> = _age

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userUsesCases.authenticationUserFirebase()
            //Log.i("FIREBASE", "authenticationUserFirebase : $result")

        }
    }

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    fun onSignUpChanged(name: String, age: String, email: String, password: String) {
        _name.value = name
        _age.value = age
        _email.value = email
        _password.value = password
        _signUpEnabled.value = isValidName(name) && isValidAge(age) && isValidEmail(email) && isValidPassword(password)
    }


    fun onSignUpClick(){
        _signUpClick.value = true
        Log.i("FIREBASE", "onSignUpChanged")

    }

    private fun isValidName(name: String): Boolean = name.length > 2
    private fun isValidAge(age: String): Boolean = age.length > 2
    private fun isValidPassword(password: String): Boolean = password.length > 6
    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

}