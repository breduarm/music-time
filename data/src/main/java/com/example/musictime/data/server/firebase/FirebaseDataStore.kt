package com.example.musictime.data.server.firebase

import android.util.Log
import com.example.musictime.domain.User
import com.example.musictime.domain.source.FirebaseDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseServices : FirebaseDataSource {
    private val reference = "https://crypto-les-default-rtdb.firebaseio.com/"
    private val path = "db_users"
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
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
            val user = id?.let { User(it, name, age, email, password) }
            databaseReference.child(path).child(id.toString()).setValue(user)
            Log.i("FIREBASE", "signUpUserFirebase : onSuccess")
    }

    override suspend fun getUserFirebase(email: String, password: String) {
        databaseReference.child(path).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.children.mapNotNull {
                    it.getValue(User::class.java)
                }
                Log.i("FIREBASE", "getUserFirebase : $data")
                Log.i("FIREBASE", "getUserFirebase [] : ${data.last()}")
                Log.i("FIREBASE", "getUserFirebase size : ${data.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("FIREBASE", "getUserFirebase : error")
            }

        })
    }

    override suspend fun loginFirebase(email: String, password: String) {
        TODO("Not yet implemented")
    }

}