import com.example.musictime.extensions.*
import org.gradle.kotlin.dsl.kapt

plugins {
    id("com.example.musictime.commons.android-library")
    id("com.example.musictime.commons.android-compose")
}

dependencies {
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
}