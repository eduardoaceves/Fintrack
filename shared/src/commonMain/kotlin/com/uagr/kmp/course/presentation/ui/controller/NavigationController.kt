/*
 * NavigationController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.controller

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.login.navigation.LoginNavigation
import com.uagr.kmp.course.presentation.ui.welcome.navigation.WelcomeNavigation

@Composable
fun NavigationController() {
    AppTheme {
        Navigator(screen = LoginNavigation) { navigator ->
            ScaleTransition(navigator)
        }
    }
}
