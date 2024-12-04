plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.apollographql.apollo") version "4.1.0"
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}
android {
    namespace = "com.thanhdang.movie"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.thanhdang.movie"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //apollo
    implementation(libs.apollo.runtime)
    implementation(libs.apollo.normalized.cache)

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    //lottie
    implementation(libs.lottie)

    // livedata & viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // recyclerview
    implementation(libs.androidx.recyclerview)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}
kapt {
    correctErrorTypes = true
}