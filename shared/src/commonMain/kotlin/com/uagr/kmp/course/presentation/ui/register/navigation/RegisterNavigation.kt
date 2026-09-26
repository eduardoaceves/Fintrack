/*
 * RegisterNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.register.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.ui.login.navigation.LoginNavigation
import com.uagr.kmp.course.presentation.ui.register.ui.RegisterScreen

data object RegisterNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        RegisterScreen(
            onRegisterSuccess = {
                navigator.replaceAll(item = LoginNavigation)
            },
            onBackClick = {
                navigator.replaceAll(item = LoginNavigation)
            }
        )
    }
}