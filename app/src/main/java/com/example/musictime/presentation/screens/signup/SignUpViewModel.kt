package com.example.musictime.presentation.screens.signup

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
class SignUpViewModel @Inject constructor(
    private val authenticationUsesCases: AuthenticationUsesCases,
): ViewModel()  {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _emailSignUp = MutableLiveData<String>()
    val emailSignUp : LiveData<String> = _emailSignUp

    private val _passwordSignUp = MutableLiveData<String>()
    val passwordSignUp : LiveData<String> = _passwordSignUp

    private val _signUpEnabled = MutableLiveData<Boolean>()
    val signUpEnabled : LiveData<Boolean> = _signUpEnabled

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress

    private val _signupSuccess = MutableLiveData<Boolean>()
    val signupSuccess : LiveData<Boolean> = _signupSuccess

    fun onSignUpChanged(name: String, email: String, password: String) {
        _name.value = name
        _emailSignUp.value = email
        _passwordSignUp.value = password
        _signUpEnabled.value = isValidName(name)  && isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidName(name: String): Boolean = name.length > 2
    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length >= 6

    fun requestSignUp(){
        _showProgress.value = true
        _signupSuccess.value = false
        viewModelScope.launch(Dispatchers.IO) {
            val result = authenticationUsesCases.signUpUserFirebase(_name.value!!, "Default", _emailSignUp.value!!, _passwordSignUp.value!!)
            Log.i("FIREBASE", "signUpUserFirebase : $result")
            _signupSuccess.postValue(result)
        }
    }


}