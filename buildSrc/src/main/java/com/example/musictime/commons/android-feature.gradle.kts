package com.example.musictime.commons

import com.example.musictime.extensions.*
import gradle.kotlin.dsl.accessors._3c6ee9b007cd6a6a058778a63acc8faa.android
import gradle.kotlin.dsl.accessors._3c6ee9b007cd6a6a058778a63acc8faa.kotlin
import gradle.kotlin.dsl.accessors._3c6ee9b007cd6a6a058778a63acc8faa.kotlinOptions
import gradle.kotlin.dsl.accessors._3c6ee9b007cd6a6a058778a63acc8faa.sourceSets

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("org.jetbrains.kotlin.kapt")
}

android {

    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}


android.libraryVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    // Common
    addCommonDependencies()
    // Test
    addTestDependencies()
}