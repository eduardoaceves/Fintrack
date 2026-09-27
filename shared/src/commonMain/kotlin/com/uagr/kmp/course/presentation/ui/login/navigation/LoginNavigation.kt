/*
 * LoginNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.ui.tabs.home.navigation.HomeNavigation
import com.uagr.kmp.course.presentation.ui.login.ui.LoginScreen
import com.uagr.kmp.course.presentation.ui.packages.navigation.PackagesNavigation
import com.uagr.kmp.course.presentation.ui.register.navigation.RegisterNavigation

data object LoginNavigation : Screen  {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LoginScreen(
            onCreateAccountClick = {
                navigator.push(item = RegisterNavigation)
            },
            onLoginSuccess = {
                navigator.replaceAll(item = PackagesNavigation)
            },
            onHomeClick = {
                navigator.replaceAll(HomeNavigation)
            }
        )
    }
}
