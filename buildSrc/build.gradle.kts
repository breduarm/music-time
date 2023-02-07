plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

object Versions {
    const val GRADLE = "7.3.1"
    const val KOTLIN = "1.7.0"
    const val HILT = "2.42"
}

object Deps {
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
}

dependencies {
    implementation(Deps.ANDROID_GRADLE)
    implementation(Deps.KOTLIN_GRADLE)
    implementation(Deps.HILT)
}

