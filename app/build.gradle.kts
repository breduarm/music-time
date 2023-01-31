import com.example.musictime.DaggerHiltLib
import com.example.musictime.SupportLib
import com.example.musictime.extensions.*

plugins {
    /*
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")*/
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    //namespace = "com.example.musictime"

    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.musictime"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            //signingConfig = signingConfigs.getByName("signingConfigRelease")
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,gralde-plugins}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    // Modules
    addModuleDependencies()
    // Common
    addCommonDependencies()
    // Compose
    addComposeDependencies()
    // Navigation
    addNavigationDependencies()
    // Network
    addNetworkDependencies()
    // Storage
    addStorageDependencies()
    // Core
    implementation(SupportLib.Splashscreen)
    // Dagger Hilt
    implementation(DaggerHiltLib.Android)
    kapt(DaggerHiltLib.Compiler)
    implementation(DaggerHiltLib.Compose)
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    /*
    implementation 'androidx.core:core-ktx:1.9.0'
    implementation "androidx.compose.ui:ui:$composeVersion"
    implementation "androidx.compose.material:material:$composeVersion"
    implementation "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.5.1'
    implementation 'androidx.activity:activity-compose:1.6.0'
    implementation 'com.google.android.material:material:1.5.0'

    // Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.42"
    kapt "com.google.dagger:hilt-android-compiler:2.42"
    kapt 'androidx.hilt:hilt-compiler:1.0.0'
    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'

    // Splash API
    implementation 'androidx.core:core-splashscreen:1.0.0'

    // DataStore Preferences
    implementation "androidx.datastore:datastore-preferences:1.0.0"

    // Coil
    implementation "io.coil-kt:coil-compose:2.1.0"

    // Compose Navigation
    implementation "androidx.navigation:navigation-compose:2.5.3"

    // Horizontal Pager and Indicators - Accompanist
    implementation "com.google.accompanist:accompanist-pager:$accompanistVersion"
    implementation "com.google.accompanist:accompanist-pager-indicators:$accompanistVersion"

    //Icons
    implementation "androidx.compose.material:material-icons-extended:$composeVersion"

    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$composeVersion"
    debugImplementation "androidx.compose.ui:ui-tooling:$composeVersion"
    //Room
    implementation "androidx.room:room-ktx:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    //di
    implementation 'com.google.dagger:hilt-android:2.40.5'
    kapt 'com.google.dagger:hilt-compiler:2.40.5'*/
}