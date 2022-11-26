package com.example.musictime.auth.google

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthGoogleViewModel: ViewModel() {

    private val _loadingState = MutableStateFlow(LoadingState.IDLE)
    val loadingState get() =  _loadingState.asStateFlow()

    fun signWithCredential(credential: AuthCredential) = viewModelScope.launch {
        try {
            val authResult = Firebase.auth.signInWithCredential(credential).await()
            authResult.additionalUserInfo?.isNewUser
            _loadingState.emit(LoadingState.SUCCESS)
            Firebase.auth.signOut()
        } catch (e: ApiException) {
            _loadingState.emit(LoadingState.error(e.localizedMessage))
        }
    }
}