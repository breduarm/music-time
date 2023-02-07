import com.example.musictime.DaggerHiltLib
import com.example.musictime.StorageLib
import com.example.musictime.extensions.*

plugins {
    id("com.example.musictime.commons.android-library")
    id("dagger.hilt.android.plugin")
}

dependencies {
    DOMAIN
    implementation(StorageLib.RoomKtx)
    kapt(StorageLib.RoomCompiler)
    implementation(DaggerHiltLib.Android)
    kapt(DaggerHiltLib.Compiler)
    implementation(StorageLib.DatastorePref)
}