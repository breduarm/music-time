package com.example.musictime.login

import com.example.musictime.presentation.screens.login.Callback
import com.google.firebase.firestore.FirebaseFirestore


const val MUSIC_COLLECTION_NAME = "music"
const val USERS_COLLECTION_NAME = "users"

class FirebaseService (val firebaseFirestone: FirebaseFirestore){

    fun setDocument(data: Any, collectionName: String, id: String, callback: Callback<Void>){
        firebaseFirestone.collection(collectionName).document(id).set(data)
            .addOnCompleteListener { callback.onSuccess(null) }
            .addOnFailureListener { exception -> callback.onFailed(exception) }
    }

    /*
    fun updateUser(user: User, callback: Callback<User>?){
        firebaseFirestone.collection(USERS_COLLECTION_NAME).document(user.username)
            .update("musicList", user.musicList)
            .addOnSuccessListener {
                callback?.onSuccess(user)
            }
            .addOnFailureListener { exception -> callback!!.onFailed(exception) }

    }

    fun updateMusic(music: Music){
        firebaseFirestone.collection(MUSIC_COLLECTION_NAME).document(music.getDocumentId())
            .update("item", music.item)
    }

     */

}