import com.example.musictime.DaggerHiltLib
import com.example.musictime.extensions.*

plugins {
    id("com.example.musictime.commons.android-library")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(DaggerHiltLib.Android)
    kapt(DaggerHiltLib.Compiler)
}