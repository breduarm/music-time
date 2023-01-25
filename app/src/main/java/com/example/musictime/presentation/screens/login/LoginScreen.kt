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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musictime.R
import com.example.musictime.domain.Users
import com.example.musictime.navigation.navgraph.Graph
import com.example.musictime.ui.theme.colorPrimary
import com.google.firebase.database.*

@Composable
fun LoginScreen(
    rootNavController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .background(colorPrimary)
            .fillMaxSize()
            .padding(16.dp),

        ) {
        Login(Modifier.align(Alignment.TopStart), viewModel, rootNavController)
        VersionEnd(Modifier.align(Alignment.BottomCenter))

    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, rootNavController: NavHostController) {
    val name: String by viewModel.name.observeAsState(initial = "")
    val age: String by viewModel.age.observeAsState(initial = "")
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val emailSignUp: String by viewModel.emailSignUp.observeAsState(initial = "")
    val passwordSignUp: String by viewModel.passwordSignUp.observeAsState(initial = "")
    val loginEnabled: Boolean by viewModel.loginEnabled.observeAsState(initial = false)
    val signUpEnabled: Boolean by viewModel.signUpEnabled.observeAsState(initial = false)
    val sigUpSwitch: Boolean by viewModel.signUpSwitch.observeAsState(initial = false)
   // var auth: FirebaseAuth = FirebaseAuth.getInstance()
   // var firebaseService: FirebaseService = FirebaseService(FirebaseFirestore.getInstance())
   // val databaseReference = FirebaseDatabase.getInstance()
     //   .getReferenceFromUrl("https://crypto-les-default-rtdb.firebaseio.com/")

    Column(modifier = modifier) {
        /** Login */
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        EmailField(sigUpSwitch, email){ viewModel.onLoginChanged(it, password)}
        PasswordField(sigUpSwitch, password) { viewModel.onLoginChanged(email, it)}
        ForgotPasswordButton(sigUpSwitch, Modifier.align(Alignment.End))
        LoginButton(sigUpSwitch, loginEnabled)
        SignUpButton(sigUpSwitch, Modifier.align(Alignment.CenterHorizontally), viewModel)
        /** Sign Up */
        // GetUserData(databaseReference)
        NameField(sigUpSwitch, name) { viewModel.onSignUpChanged(it, age, email, password) }
        AgeField(sigUpSwitch, age) { viewModel.onSignUpChanged(name, it, email, password) }
        EmailFieldSignUp(sigUpSwitch, emailSignUp) { viewModel.onSignUpChanged(name, age, it, passwordSignUp) }
        PasswordFieldSignUp(sigUpSwitch, passwordSignUp) { viewModel.onSignUpChanged(name, age, emailSignUp, it) }
        SignUpRegisterButton(sigUpSwitch, signUpEnabled, viewModel)
        LoginBackButton(sigUpSwitch, Modifier.align(Alignment.CenterHorizontally), viewModel)
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
                    Log.i("LOGIN", "GetUserData [] : ${data[0]}")
                    Log.i("LOGIN", "GetUserData size : ${data.size}")

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
fun LoginButton(signUpSwitch: Boolean, loginEnabled: Boolean) {
    if(!signUpSwitch){
        Button(
            onClick = {
                /*
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

                 */
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

        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun SignUpRegisterButton(signUpSwitch: Boolean, signUpEnabled: Boolean, viewModel: LoginViewModel) {
    if(signUpSwitch){
        Button(
            onClick = { viewModel.requestSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFC8F0D6),
                disabledBackgroundColor = Color(0x8BC8F0D6),
                contentColor = Color(0xFF222838),
                disabledContentColor = Color(0xFF222838)
            ),
            enabled = signUpEnabled
        ) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun LoginBackButton(signUpEnabled: Boolean, modifier: Modifier, viewModel: LoginViewModel) {
    if(signUpEnabled){
        Text(
            text = "Login",
            modifier = modifier.clickable { viewModel.onLoginBackClick() },
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun VersionEnd(modifier: Modifier) {
    Text(
        text = "©LT",
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
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
fun SignUpButton(signUpEnabled: Boolean, modifier: Modifier, viewModel: LoginViewModel) {
    if(!signUpEnabled){
        Text(
            text = "Sign up",
            modifier = modifier.clickable { viewModel.onSignUpClick() },
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ForgotPasswordButton(signUpEnabled: Boolean, modifier: Modifier) {
    if(!signUpEnabled){
        Text(
            text = "Forgot Password?",
            modifier = modifier.clickable { },
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun EmailField(signUpEnabled: Boolean, email: String, onTextFieldChanged: (String) -> Unit) {
    if(!signUpEnabled){
        TextField(
            value = email,
            onValueChange = { onTextFieldChanged(it) },
            placeholder = { Text(text = "Email", color = Color(0xFF222838)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF4E5C81),
                backgroundColor = Color.White,
                focusedIndicatorColor = Color(0xFFFED0D2),
                unfocusedIndicatorColor = Color(0xFFC8F0D6)
            ),
        )

        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun PasswordField(signUpEnabled: Boolean, password: String, onTextFieldChanged: (String) -> Unit) {
    if(!signUpEnabled){
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

        Spacer(modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun NameField(signUpEnabled: Boolean, name: String, onTextFieldChanged: (String) -> Unit) {
    if(signUpEnabled){
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
        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun AgeField(signUpEnabled: Boolean, age: String, onTextFieldChanged: (String) -> Unit) {
    if(signUpEnabled){
        TextField(
            value = age,
            onValueChange = { onTextFieldChanged(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Age", color = Color(0xFF222838)) },
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
        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun EmailFieldSignUp(signUpEnabled: Boolean, email: String, onTextFieldChanged: (String) -> Unit) {
    if(signUpEnabled){
        TextField(
            value = email,
            onValueChange = { onTextFieldChanged(it) },
            placeholder = { Text(text = "Email", color = Color(0xFF222838)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF4E5C81),
                backgroundColor = Color.White,
                focusedIndicatorColor = Color(0xFFFED0D2),
                unfocusedIndicatorColor = Color(0xFFC8F0D6)
            ),
        )

        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun PasswordFieldSignUp(signUpEnabled: Boolean, password: String, onTextFieldChanged: (String) -> Unit) {
    if(signUpEnabled){
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

        Spacer(modifier = Modifier.padding(8.dp))
    }
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
    LoginScreen(rootNavController = rememberNavController())
}