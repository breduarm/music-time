import com.example.musictime.extensions.*

plugins {
    id("com.example.musictime.commons.android-library")
    id("com.example.musictime.commons.android-compose")
}

dependencies {
    THEME
    COMPONENTS
    CORE
    HOME
    FAVOURITES
    SEARCH
    MUSICPLAYER

    addNavigationDependencies()
}