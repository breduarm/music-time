package com.example.musictime.presentation.screens.login


import java.util.*

class Music(var name: String = "", var image: String = "", var item: Int = 0){
    fun getDocumentId(): String{
        return name.lowercase(Locale.ROOT)
    }
}