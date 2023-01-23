package com.example.musictime.data.server.firebase

import android.util.Log
import com.example.musictime.domain.Users
import com.example.musictime.domain.source.FirebaseDataSource
import com.example.musictime.navigation.navgraph.Graph
import com.example.musictime.presentation.screens.login.FirebaseService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class FirebaseServices : FirebaseDataSource {
    private val reference = "https://crypto-les-default-rtdb.firebaseio.com/"
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseService: FirebaseService = FirebaseService(FirebaseFirestore.getInstance())
    private val databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl(reference)

    override suspend fun authenticationUserFirebase() {
        auth.signInAnonymously().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("LOGIN", "authenticationUserFirebase : isSuccessful")
                //val user = User()
                //user.username = name
                //saveUser(user, firebaseService, rootNavController)

             //   val id = databaseReference.push().key
              //  val user = Users(id, name, "les@gmail.com")
               // databaseReference.child("db_users").child(id.toString()).setValue(user)
                //Log.i("LOGIN", "firebaseService : onSuccess")
            //    rootNavController.popBackStack()
             //   rootNavController.navigate(Graph.BOTTOM)

            } else {
                Log.i("LOGIN", "authenticationUserFirebase : error")
            }
        }
    }

    override suspend fun loginUserFirebase(email: String, password: String) {
        //
    }

}