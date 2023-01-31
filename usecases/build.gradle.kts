import com.example.musictime.extensions.*
import com.example.musictime.extensions.implementation
import com.example.musictime.extensions.kapt

plugins {
    id("com.example.musictime.commons.android-library")
    id("dagger.hilt.android.plugin")
}

dependencies {
    DATA
    DOMAIN
    implementation(com.example.musictime.DaggerHiltLib.Android)
    kapt(com.example.musictime.DaggerHiltLib.Compiler)
}