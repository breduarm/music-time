package com.example.musictime.data.server.firebase

import android.util.Log
import com.example.musictime.domain.Users
import com.example.musictime.domain.source.FirebaseDataSource
import com.example.musictime.presentation.screens.login.FirebaseService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseServices : FirebaseDataSource {
    private val reference = "https://crypto-les-default-rtdb.firebaseio.com/"
    private val path = "db_users"
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseService: FirebaseService = FirebaseService(FirebaseFirestore.getInstance())
    private val databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl(reference)

    override suspend fun authenticationUserFirebase() {
        auth.signInAnonymously().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("FIREBASE", "authenticationUserFirebase : isSuccessful")
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
                Log.i("FIREBASE", "authenticationUserFirebase : error")
            }
        }
    }

    override suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String) {
            val id = databaseReference.push().key
            val user = Users(id, name, age, email, password)
            databaseReference.child(path).child(id.toString()).setValue(user)
            Log.i("FIREBASE", "signUpUserFirebase : onSuccess")
    }

    override suspend fun getUserFirebase(email: String, password: String) {
        databaseReference.child(path).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.children.mapNotNull {
                    it.getValue(Users::class.java)
                }
                Log.i("FIREBASE", "getUserFirebase : $data")
                Log.i("FIREBASE", "getUserFirebase [] : ${data[0]}")
                Log.i("FIREBASE", "getUserFirebase size : ${data.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("FIREBASE", "getUserFirebase : error")
            }

        })
    }

}