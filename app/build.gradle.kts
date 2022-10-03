plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.navigationSafeArgs)
    kotlin(BuildPlugins.kapt)
    id(BuildPlugins.hiltPlugin)
    id(BuildPlugins.detekt)
}

android {

    namespace = "example.android.exam.examplelocal1"
    compileSdk = AndroidSdk.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    coreLibraryDesugaring(Libraries.desugarJdkLibs)

    // AndroidX
    implementation(Libraries.AndroidX.core)
    implementation(Libraries.AndroidX.appCompat)
    implementation(Libraries.AndroidX.constraintLayout)
    implementation(Libraries.AndroidX.activity)
    implementation(Libraries.AndroidX.fragment)

    implementation(Libraries.AndroidX.Navigation.fragment)
    implementation(Libraries.AndroidX.Navigation.ui)

    implementation(Libraries.AndroidX.Lifecycle.common)
    implementation(Libraries.AndroidX.Lifecycle.commonJava8)
    implementation(Libraries.AndroidX.Lifecycle.runtime)
    implementation(Libraries.AndroidX.Lifecycle.liveData)
    implementation(Libraries.AndroidX.Lifecycle.viewModel)

    implementation(Libraries.View.material3)
    implementation(Libraries.Log.timber)

    // Retrofit
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.moshi)

    // Moshi
    implementation(Libraries.Moshi.moshi)

    // Hilt
    implementation(Libraries.DaggerHilt.daggerHilt)
    kapt(Libraries.DaggerHilt.daggerHiltCompiler)

    // Coroutine
    implementation(Libraries.Kotlin.Coroutines.coroutine)

    // Network
    implementation(Libraries.Network.okhttp)
    implementation(Libraries.Network.interceptor)

    // Result
    implementation(Libraries.Result.core)
    implementation(Libraries.Result.coroutine)

    testImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.junitExt)
    androidTestImplementation(TestLibraries.espresso)
}

kapt {
    correctErrorTypes = true
}
