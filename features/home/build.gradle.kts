import com.example.musictime.extensions.*
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.kapt

plugins {
    id("com.example.musictime.commons.android-library")
    id("com.example.musictime.commons.android-compose")
}

dependencies {
    DOMAIN
    THEME
    CORE
    COMPONENTS
    USECASES

    addNavigationDependencies()
    // Dagger Hilt
    implementation(com.example.musictime.DaggerHiltLib.Android)
    kapt(com.example.musictime.DaggerHiltLib.Compiler)
    implementation(com.example.musictime.DaggerHiltLib.Compose)
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation (platform("com.google.firebase:firebase-bom:31.1.1"))
    implementation ("com.google.firebase:firebase-analytics-ktx")
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.firebase:firebase-auth:21.1.0")
    implementation ("com.google.firebase:firebase-firestore:24.4.1")
    implementation ("com.google.firebase:firebase-database:20.1.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.3.2")
}