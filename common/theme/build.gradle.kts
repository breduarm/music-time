import com.example.musictime.SupportLib


plugins {
    id("com.example.musictime.commons.android-library")
    id("com.example.musictime.commons.android-compose")
}


dependencies {
    // Core
    implementation(SupportLib.Splashscreen)
}