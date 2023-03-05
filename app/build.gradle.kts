import com.example.musictime.DaggerHiltLib
import com.example.musictime.SupportLib
import com.example.musictime.extensions.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    //namespace = "com.example.musictime"

    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.musictime"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            //signingConfig = signingConfigs.getByName("signingConfigRelease")
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,gralde-plugins}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    // Modules
    addModuleDependencies()
    // Common
    addCommonDependencies()
    // Compose
    addComposeDependencies()
    // Navigation
    addNavigationDependencies()
    // Network
    addNetworkDependencies()
    // Storage
    addStorageDependencies()
    // Core
    implementation(SupportLib.Splashscreen)
    // Dagger Hilt
    implementation(DaggerHiltLib.Android)
    kapt(DaggerHiltLib.Compiler)
    implementation(DaggerHiltLib.Compose)
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.3.2")
}