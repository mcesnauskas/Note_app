plugins {
    alias(libs.plugins.androidApplication)
    kotlin("kapt")
}

android {
    namespace = "lt.mindaugas.note_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "lt.mindaugas.note_app"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // lombok
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
    // Room database
    implementation(libs.room)
    annotationProcessor(libs.rooma)
    testImplementation(libs.roomt)
}