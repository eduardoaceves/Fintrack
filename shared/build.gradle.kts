// build.gradle - shared
// Copyright (c) 2026. All rights reserved
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidx.room)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.koinCompiler)
}

kotlin {

    jvmToolchain(jdkVersion = 21)

    // Config for devices ios
    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = false
        }
    }

    android {
        namespace = "com.uagr.kmp.course.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        androidResources {
            enable = true
        }

        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    sourceSets {
        // SharedUI module
        commonMain.dependencies {
            // Bundle
            implementation(dependencyNotation = libs.bundles.sharedUI.commons.libs)
        }
        // Android
        androidMain.dependencies {
            // Bundle
            implementation(dependencyNotation = libs.bundles.sharedUI.android.libs)
        }
        // Ios
        iosMain.dependencies {
            // Bundle
            implementation(dependencyNotation = libs.bundles.sharedUI.ios.libs)
        }
        // SharedUI test
        commonTest.dependencies {
            implementation(dependencyNotation = libs.bundles.sharedUI.commonsTest.libs)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}

dependencies {
    add(configurationName = "kspCommonMainMetadata", dependencyNotation = libs.androidx.room.compiler)
    add(configurationName = "kspIosArm64", dependencyNotation = libs.androidx.room.compiler)
    add(configurationName = "kspIosSimulatorArm64", dependencyNotation = libs.androidx.room.compiler)
    add(configurationName = "kspAndroid", dependencyNotation = libs.androidx.room.compiler)
}

room {
    schemaDirectory(path = "$projectDir/schemas")
}
