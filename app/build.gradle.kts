plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kapt)
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
}

kapt {
    correctErrorTypes = true
}
