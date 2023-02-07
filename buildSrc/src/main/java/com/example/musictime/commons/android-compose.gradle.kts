package com.example.musictime.commons
import com.example.musictime.extensions.addComposeDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    addComposeConfig()
}

dependencies {
    addComposeDependencies()
}