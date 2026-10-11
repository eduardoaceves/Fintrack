/*
 * NavigationController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.ui.login.navigation.LoginNavigation
import com.uagr.kmp.course.presentation.ui.main.viewModel.MainActivityUiEvent
import com.uagr.kmp.course.presentation.ui.main.viewModel.MainActivityViewModel
import com.uagr.kmp.course.presentation.ui.tabs.home.navigation.HomeNavigation
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import com.uagr.kmp.course.utils.operators.InitialScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NavigationController(
    viewModel: MainActivityViewModel = koinViewModel(),
) {
    AppTheme {
        
        val mainActivityUiState by viewModel.mainActivityUiState.collectAsStateWithLifecycle()
        viewModel.mainActivityUiEvent.CollectWithLifecycle { event ->
            when (event) {
                is MainActivityUiEvent.Idle -> {}
                else -> {
                    viewModel.resetUiEvent()
                }
            }
        }
        
        when(mainActivityUiState.initialScreen) {
            InitialScreen.HOME_SCREEN -> {
                Navigator(screen = HomeNavigation) { navigator ->
                    ScaleTransition(navigator)
                }
            }
            InitialScreen.LOGIN_SCREEN -> {
                Navigator(screen = LoginNavigation) { navigator ->
                    ScaleTransition(navigator)
                }
            }
            else -> {}
        }
    }
}

