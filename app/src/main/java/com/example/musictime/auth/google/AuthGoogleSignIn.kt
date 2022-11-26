package com.example.musictime.auth.google

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musictime.R
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun AuthGoogleSignIn(viewModel: AuthGoogleViewModel = viewModel()) {

    val state by viewModel.loadingState.collectAsState()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val tokenWebId = stringResource(id = R.string.default_web_client_id)
    val launcher = rememberLauncherForActivityResult(contract = AuthGoogleResultContract(tokenWebId)) { result ->
        try {
            val account = result?.getResult(ApiException::class.java)
            if (account == null) {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Por favor, inicie sesion para ingresar!"
                    )
                }
                Log.w("TAG", "No se puede iniciar sesión en Google!", result?.exception?.fillInStackTrace())
            } else {
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                viewModel.signWithCredential(credential)
            }
        } catch (e: ApiException) {
            Log.w("TAG", "No se puede iniciar sesión en Google!", e.cause)
        }
    }

    Scaffold(scaffoldState = scaffoldState) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            GoogleSignInButtonUi(
                text = "Sign Up with Google",
                loadingText = "Signing in...",
                onClicked = {
                    launcher.launch(1)
                }
            )
        }

        when(state.status) {
            Status.SUCCESS -> {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Ingreso exitoso!"
                    )
                }
            }
            Status.FAILED -> {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "No se pudo iniciar ${state.msg}"
                    )
                }
            }
            else -> {}
        }
    }
}