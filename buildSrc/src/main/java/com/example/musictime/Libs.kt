package com.example.musictime

object Versions {
    const val COMPOSE = "1.2.0"
    const val CORE_KTX = "1.9.0"
    const val ROOM = "2.4.3"
    const val DATASTORE = "1.0.0"
    const val HILT = "2.42"
}

object SupportLib {
    const val CoreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val Material = "com.google.android.material:material:1.5.0"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val Splashscreen = "androidx.core:core-splashscreen:1.0.0"
}

object ComposeLib {
    const val Ui = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val Material = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val Preview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val MaterialIconExtended = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE}"
    const val Tooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val Activity = "androidx.activity:activity-compose:1.6.0"
    const val Coil = "io.coil-kt:coil-compose:2.0.0-rc02"
}

object NavigationLib {
    const val Navigation = "androidx.navigation:navigation-compose:2.5.3"
}

object AccompanistLib {
    const val Pager = "com.google.accompanist:accompanist-pager:0.25.1"
    const val Indicators = "com.google.accompanist:accompanist-pager-indicators:0.25.1"
}

object NetworkLib {

}

object StorageLib {
    const val RoomKtx = "androidx.room:room-ktx:${Versions.ROOM}"
    const val RoomCompiler = "androidx.room:room-compiler:${Versions.ROOM}"
    const val DatastorePref = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
    const val Datastore = "androidx.datastore:datastore:${Versions.DATASTORE}"
}

object DaggerHiltLib {
    const val Android = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val Compiler = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val Compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
}

object TestingLib {
    const val Junit = "junit:junit:4.13.2"
}

object AndroidTestingLib {
    const val JunitExt = "androidx.test.ext:junit:1.1.3"
    const val ComposeTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val EspressoCore = "androidx.test.espresso:espresso-core:3.4.0"
}

object FirebaseLib{
    const val Bom = "com.google.firebase:firebase-bom:31.1.1"
    const val Analytics = "com.google.firebase:firebase-analytics-ktx"
    const val Authentication = "com.google.firebase:firebase-auth:21.1.0"
    const val Core = "com.google.firebase:firebase-core:21.1.1"
    const val Firestone = "com.google.firebase:firebase-firestore:24.4.1"
    const val Database = "com.google.firebase:firebase-database:20.1.0"
}


