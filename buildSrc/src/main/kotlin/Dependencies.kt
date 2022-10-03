object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val kapt = "kapt"
}

object AndroidSdk {
    const val minSdk = 23
    const val targetSdk = 32
    const val compileSdk = 32
}

object AppConfig {
    const val applicationId = "example.android.exam.examplelocal1"
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Libraries {
    object Versions {
        const val desugarJdkLibs = "1.1.8"
        const val spotless = "6.10.0"
        const val ktlint = "0.46.1"

        object AndroidX {
            const val appCompat = "1.5.0"
            const val constraintLayout = "2.1.4"
            const val ktx = "1.7.0"
            const val navigation = "2.5.2"
            const val lifecycle = "2.5.1"
            const val activity = "1.5.1"
            const val fragment = "1.5.2"
        }

        object Kotlin {
            object Coroutines {
                const val coroutine = "1.6.4"
            }
        }

        object View {
            const val material = "1.6.1"
        }

        object Log {
            const val timber = "5.0.1"
        }
    }

    const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.desugarJdkLibs}"

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.AndroidX.ktx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"

        object Navigation {
            const val fragment =
                "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.navigation}"
        }

        object Lifecycle {
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
            const val liveData =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.lifecycle}"
            const val runtime =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"
            const val commonJava8 =
                "androidx.lifecycle:lifecycle-common-java8:${Versions.AndroidX.lifecycle}"
            const val common = "androidx.lifecycle:lifecycle-common:${Versions.AndroidX.lifecycle}"
        }

        const val activity = "androidx.activity:activity-ktx:${Versions.AndroidX.activity}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragment}"
    }

    object Kotlin {
        object Coroutines {
            const val coroutine =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.Coroutines.coroutine}"
        }
    }

    object View {
        const val material3 = "com.google.android.material:material:${Versions.View.material}"
    }

    object Log {
        const val timber = "com.jakewharton.timber:timber:${Versions.Log.timber}"
    }


}

object TestLibraries {}
