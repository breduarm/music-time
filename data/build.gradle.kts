import com.example.musictime.DaggerHiltLib
import com.example.musictime.FirebaseLib
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
    implementation (platform("com.google.firebase:firebase-bom:31.1.1"))
    implementation ("com.google.firebase:firebase-analytics-ktx")
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.firebase:firebase-auth:21.1.0")
    implementation ("com.google.firebase:firebase-firestore:24.4.1")
    implementation ("com.google.firebase:firebase-database:20.1.0") 
    //addFirebaseDependencies()

}