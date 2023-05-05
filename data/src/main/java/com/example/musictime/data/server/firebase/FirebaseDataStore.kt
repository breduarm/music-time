package com.example.musictime.data.server.firebase

import android.util.Log
import com.example.musictime.domain.User
import com.example.musictime.domain.source.FirebaseDataSource
import com.example.musictime.domain.source.LocalDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class FirebaseServices : FirebaseDataSource {
    private val reference = "https://crypto-les-default-rtdb.firebaseio.com/"
    private val path = "db_users"
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl(reference)
    private lateinit var localDataSource: LocalDataSource

    override suspend fun authenticationUserFirebase() {
        auth.signInAnonymously().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i("FIREBASE", "authenticationUserFirebase : isSuccessful")
            } else {
                Log.i("FIREBASE", "authenticationUserFirebase : error")
            }
        }
    }

    override suspend fun signUpUserFirebase(name: String, age: String, email: String, password: String, callback: (Boolean)->Unit) {
            val id = databaseReference.push().key
            val user = id?.let { User(it, name, age, email, password) }
            databaseReference.child(path).child(id.toString()).setValue(user)
            callback(true)
            Log.i("FIREBASE", "signUpUserFirebase : onSuccess")
    }


    override suspend fun getUserFirebase(email: String, password: String, callback: (Boolean)->Unit){
        databaseReference.child(path).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.children.mapNotNull {
                    it.getValue(User::class.java)
                }

                Log.i("FIREBASE", "getUserFirebase size : ${data.size}")
                for (item in data) {
                    //Log.i("FIREBASE", "item.email : ${item.email}")
                    //Log.i("FIREBASE", "item.email : ${item.password}")
                    if(item.email == email && item.password == password){
                        callback(true)
                        return
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) { Log.i("FIREBASE", "getUserFirebase : error") }
        })
    }

    override suspend fun loginFirebase(email: String, password: String) { }

}