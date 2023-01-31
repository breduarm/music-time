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

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _age = MutableLiveData<String>()
    val age : LiveData<String> = _age

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _emailSignUp = MutableLiveData<String>()
    val emailSignUp : LiveData<String> = _emailSignUp

    private val _passwordSignUp = MutableLiveData<String>()
    val passwordSignUp : LiveData<String> = _passwordSignUp

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled : LiveData<Boolean> = _loginEnabled

    private val _signUpEnabled = MutableLiveData<Boolean>()
    val signUpEnabled : LiveData<Boolean> = _signUpEnabled

    private val _signUpSwitch = MutableLiveData<Boolean>()
    val signUpSwitch : LiveData<Boolean> = _signUpSwitch

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess : LiveData<Boolean> = _loginSuccess

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userUsesCases.authenticationUserFirebase()
            Log.i("FIREBASE", "authenticationUserFirebase : $result")
            val getUser = userUsesCases.getUserFirebase("", "")
            Log.i("FIREBASE", "getUserFirebase : $getUser")

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
        _emailSignUp.value = email
        _passwordSignUp.value = password
        _signUpEnabled.value = isValidName(name) && isValidAge(age) && isValidEmail(email) && isValidPassword(password)
    }

    fun onSignUpClick(){ _signUpSwitch.value = true }

    fun onLoginBackClick() { _signUpSwitch.value = false }

    private fun isValidName(name: String): Boolean = name.length > 2
    private fun isValidAge(age: String): Boolean = age.length >= 2
    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length >= 6

    fun requestSignUp(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = userUsesCases.signUpUserFirebase(_name.value!!, _age.value!!, _emailSignUp.value!!, _passwordSignUp.value!!)
            Log.i("FIREBASE", "signUpUserFirebase : $result")

        }
    }

    fun requestLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userUsesCases.loginFirebase(_email.value!!, _password.value!!)
            Log.i("FIREBASE", "loginFirebase : $result")
            _loginSuccess.postValue(result)
        }
    }





}