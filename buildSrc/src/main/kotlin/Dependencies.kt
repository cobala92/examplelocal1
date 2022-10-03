object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val kapt = "kapt"
    const val hiltPlugin = "dagger.hilt.android.plugin"
    const val spotless = "com.diffplug.spotless"
    const val detekt = "io.gitlab.arturbosch.detekt"
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

        object DaggerHilt {
            const val daggerHilt = "2.42"
        }

        object Retrofit {
            const val retrofit = "2.9.0"
            const val moshi = "2.9.0"
        }

        object Moshi {
            const val moshi = "1.14.0"
        }

        object Network {
            const val okhttp = "4.10.0"
            const val interceptor = "4.10.0"
        }

        object Result {
            const val core = "1.1.16"
            const val coroutine = "1.1.16"
        }

        object Linter {
            const val detekt = "1.21.0"
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

    object DaggerHilt {
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.DaggerHilt.daggerHilt}"
        const val daggerHiltCompiler =
            "com.google.dagger:hilt-compiler:${Versions.DaggerHilt.daggerHilt}"
        const val hiltPlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.DaggerHilt.daggerHilt}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.Retrofit.moshi}"
    }

    object Network {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Network.okhttp}"
        const val interceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Network.interceptor}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.Moshi.moshi}"
    }

    object Result {
        const val core = "com.michael-bull.kotlin-result:kotlin-result:${Versions.Result.core}"
        const val coroutine =
            "com.michael-bull.kotlin-result:kotlin-result-coroutines:${Versions.Result.coroutine}"
    }

    object Linter {
        const val detekt =
            "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.Linter.detekt}"
    }
}

object TestLibraries {
    private object Versions {
        const val junit = "4.13.2"
        const val junitExt = "1.1.3"
        const val espresso = "3.4.0"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
