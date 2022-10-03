// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id(BuildPlugins.navigationSafeArgs) version Libraries.Versions.AndroidX.navigation apply false
    id(BuildPlugins.spotless) version Libraries.Versions.spotless apply false
    id(BuildPlugins.detekt) version Libraries.Versions.Linter.detekt
}

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath(Libraries.DaggerHilt.hiltPlugin)
        classpath(Libraries.Linter.detekt)
    }
}

detekt {
    ignoreFailures = true // We do not want to crash if warnings found, cause they will be used later

    parallel = true // Runs detekt checks in parallel

    buildUponDefaultConfig = true // Tells the detekt to use default config if its settings are not overriden in explicit config
}
