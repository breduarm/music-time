package com.example.musictime.extensions

import com.example.musictime.*
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Adds a dependency to the `releaseImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds a dependency to the `ksp` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? =
    add("ksp", dependencyNotation)

fun DependencyHandler.addCommonDependencies() {
    implementation(SupportLib.CoreKtx)
    implementation(SupportLib.Material)
    implementation(SupportLib.LifecycleRuntime)
}

fun DependencyHandler.addComposeDependencies() {
    implementation(ComposeLib.Ui)
    implementation(ComposeLib.Material)
    implementation(ComposeLib.Preview)
    implementation(ComposeLib.MaterialIconExtended)
    androidTestImplementation(AndroidTestingLib.ComposeTestJunit)
    debugImplementation(ComposeLib.Tooling)
    implementation(ComposeLib.Activity)
    implementation(ComposeLib.Coil)
    implementation(AccompanistLib.Pager)
    implementation(AccompanistLib.Indicators)
}

fun DependencyHandler.addNavigationDependencies() {
    implementation(NavigationLib.Navigation)
}

fun DependencyHandler.addNetworkDependencies() {
}

fun DependencyHandler.addStorageDependencies() {
    implementation(StorageLib.RoomKtx)
    kapt(StorageLib.RoomCompiler)
    implementation(StorageLib.DatastorePref)
    implementation(StorageLib.Datastore)
}

fun DependencyHandler.addTestDependencies() {
    // Test
    testImplementation(TestingLib.Junit)
    androidTestImplementation(AndroidTestingLib.JunitExt)
    androidTestImplementation(AndroidTestingLib.EspressoCore)
}


fun DependencyHandler.addModuleDependencies() {
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":usecases")))
    implementation(project(mapOf("path" to ":common:theme")))
    implementation(project(mapOf("path" to ":common:components")))
    implementation(project(mapOf("path" to ":common:core")))
    implementation(project(mapOf("path" to ":features:bottombar")))
    implementation(project(mapOf("path" to ":features:favourites")))
    implementation(project(mapOf("path" to ":features:home")))
    implementation(project(mapOf("path" to ":features:login")))
    implementation(project(mapOf("path" to ":features:musicplayer")))
    implementation(project(mapOf("path" to ":features:onboarding")))
    implementation(project(mapOf("path" to ":features:search")))
    implementation(project(mapOf("path" to ":features:splash")))
}

val DependencyHandler.DOMAIN
    get() = implementation(project(mapOf("path" to ":domain")))
val DependencyHandler.DATA
    get() = implementation(project(mapOf("path" to ":data")))
val DependencyHandler.USECASES
    get() = implementation(project(mapOf("path" to ":usecases")))
val DependencyHandler.THEME
    get() = implementation(project(mapOf("path" to ":common:theme")))
val DependencyHandler.COMPONENTS
    get() = implementation(project(mapOf("path" to ":common:components")))
val DependencyHandler.CORE
    get() = implementation(project(mapOf("path" to ":common:core")))
val DependencyHandler.BOTTOMBAR
    get() = implementation(project(mapOf("path" to ":features:bottombar")))
val DependencyHandler.HOME
    get() = implementation(project(mapOf("path" to ":features:home")))
val DependencyHandler.FAVOURITES
    get() = implementation(project(mapOf("path" to ":features:favourites")))
val DependencyHandler.SEARCH
    get() = implementation(project(mapOf("path" to ":features:search")))
val DependencyHandler.LOGIN
    get() = implementation(project(mapOf("path" to ":features:login")))
val DependencyHandler.MUSICPLAYER
    get() = implementation(project(mapOf("path" to ":features:musicplayer")))
val DependencyHandler.ONBOARDING
    get() = implementation(project(mapOf("path" to ":features:onboarding")))
val DependencyHandler.SPLASH
    get() = implementation(project(mapOf("path" to ":features:splash")))





