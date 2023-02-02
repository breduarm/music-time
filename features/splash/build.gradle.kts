import com.example.musictime.SupportLib
import com.example.musictime.extensions.CORE
import com.example.musictime.extensions.USECASES
import com.example.musictime.extensions.implementation

plugins {
    id("com.example.musictime.commons.android-library")
    id("com.example.musictime.commons.android-compose")
}

dependencies {
    CORE
    USECASES

    implementation(SupportLib.Splashscreen)
    implementation(com.example.musictime.DaggerHiltLib.Android)
    kapt(com.example.musictime.DaggerHiltLib.Compiler)
}