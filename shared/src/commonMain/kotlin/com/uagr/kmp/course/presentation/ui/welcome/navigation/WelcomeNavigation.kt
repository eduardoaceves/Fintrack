/*
 * WelcomeNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.welcome.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.ui.login.navigation.LoginNavigation
import com.uagr.kmp.course.presentation.ui.welcome.ui.WelcomeScreen

data object WelcomeNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        WelcomeScreen(
            navigateToPackages = {
                navigator.push(item = LoginNavigation)
            },
        )
    }
}
