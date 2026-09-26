// build.gradle - androidApp
// Copyright (c) 2026. All rights reserved
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    jvmToolchain(jdkVersion = 21)
}

android {

    namespace = "com.uagr.kmp.course.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.app.packg.name.get()
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Modules
    implementation(project(projectPath = ":shared"))
    // Libs
    implementation(libs.bundles.androidApp.libs)
    // Debug
    debugImplementation(libs.compose.uiTooling)
}
