/*
 * MainActivity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import com.uagr.kmp.course.presentation.ui.controller.NavigationController

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { false }
        setContent {
            NavigationController()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    NavigationController()
}
