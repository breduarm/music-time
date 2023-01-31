import com.example.musictime.DaggerHiltLib
import com.example.musictime.extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id("com.example.musictime.commons.android-library")
    id("com.example.musictime.commons.android-compose")
}

dependencies {
    USECASES
    DATA
    DOMAIN
    THEME
    COMPONENTS

    addNavigationDependencies()
    // Dagger Hilt
    implementation(DaggerHiltLib.Android)
    kapt(DaggerHiltLib.Compiler)
    implementation(DaggerHiltLib.Compose)
}