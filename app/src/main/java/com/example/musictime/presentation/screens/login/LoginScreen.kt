package com.example.musictime.presentation.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.R
import com.example.musictime.navigation.navgraph.Graph
import com.example.musictime.ui.theme.colorPrimary
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    rootNavController: NavHostController
) {
    Box(
        modifier = Modifier
            .background(colorPrimary)
            .fillMaxSize()
            .padding(16.dp),

        ) {
        Login(Modifier.align(Alignment.Center), viewModel, rootNavController)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, rootNavController: NavHostController) {
    val name: String by viewModel.name.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnabled: Boolean by viewModel.loginEnabled.observeAsState(initial = false)
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var firebaseService: FirebaseService = FirebaseService(FirebaseFirestore.getInstance())
    val databaseReference = FirebaseDatabase.getInstance()
        .getReferenceFromUrl("https://crypto-les-default-rtdb.firebaseio.com/")

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        NameField(name) { viewModel.onLoginChanged(it, password) }
        //Spacer(modifier = Modifier.padding(8.dp))
        //PasswordField(password) { viewModel.onLoginChanged(name, it)}
        //Spacer(modifier = Modifier.padding(8.dp))
        //ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(loginEnabled, rootNavController, auth, name, firebaseService, databaseReference)
        Spacer(modifier = Modifier.padding(8.dp))
        GetUserData(databaseReference)
    }

}

@Composable
fun GetUserData(databaseReference: DatabaseReference) {
    Button(
        onClick = {
            databaseReference.child("db_users").addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val data = snapshot.children.mapNotNull {
                        it.getValue(Users::class.java)
                    }
                    Log.i("LOGIN", "GetUserData : $data")

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
            val data: List<Users>
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFC8F0D6),
            disabledBackgroundColor = Color(0x8BC8F0D6),
            contentColor = Color(0xFF222838),
            disabledContentColor = Color(0xFF222838)
        ),
    ) {
        Text(text = "Get User Data")
    }
}

@Composable
fun LoginButton(
    loginEnabled: Boolean,
    rootNavController: NavHostController,
    auth: FirebaseAuth,
    name: String,
    firebaseService: FirebaseService,
    databaseReference: DatabaseReference
) {
    Button(
        onClick = {
            auth.signInAnonymously()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.i("LOGIN", "auth : isSuccessful")
                        //val user = User()
                        //user.username = name
                        //saveUser(user, firebaseService, rootNavController)

                        val id = databaseReference.push().key
                        val user = Users(id, name, "les@gmail.com")
                        databaseReference.child("db_users").child(id.toString()).setValue(user)
                        Log.i("LOGIN", "firebaseService : onSuccess")
                        rootNavController.popBackStack()
                        rootNavController.navigate(Graph.BOTTOM)

                    } else {
                        Log.i("LOGIN", "auth : error")
                    }
                }

            //rootNavController.popBackStack()
            //rootNavController.navigate(Graph.BOTTOM)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFC8F0D6),
            disabledBackgroundColor = Color(0x8BC8F0D6),
            contentColor = Color(0xFF222838),
            disabledContentColor = Color(0xFF222838)
        ),
        enabled = loginEnabled
    ) {
        Text(text = "Login")

    }
}

fun saveUser(user: User, firebaseService: FirebaseService, rootNavController: NavHostController) {
    firebaseService.setDocument(
        user,
        USERS_COLLECTION_NAME,
        user.username,
        object : Callback<Void> {
            override fun onSuccess(result: Void?) {
                Log.i("LOGIN", "firebaseService : onSuccess")
                rootNavController.popBackStack()
                rootNavController.navigate(Graph.BOTTOM)
            }

            override fun onFailed(exception: Exception) {
                Log.i("LOGIN", "firebaseService : $exception")
            }
        })

}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Password", color = Color(0xFF222838)) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF4E5C81),
            backgroundColor = Color.White,
            focusedIndicatorColor = Color(0xFFFED0D2),
            unfocusedIndicatorColor = Color(0xFFC8F0D6)
        )
    )

}


@Composable
fun NameField(name: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Name", color = Color(0xFF222838)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF4E5C81),
            backgroundColor = Color.White,
            focusedIndicatorColor = Color(0xFFFED0D2),
            unfocusedIndicatorColor = Color(0xFFC8F0D6)

        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Header",
        modifier = modifier
            .fillMaxWidth()
            .width(200.dp)
            .height(200.dp),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rootNavController = rememberNavController(), viewModel = LoginViewModel())
}