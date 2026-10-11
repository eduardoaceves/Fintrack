/*
 * MainActivityUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.main.viewModel

import com.uagr.kmp.course.utils.operators.InitialScreen

data class MainActivityUiState(
    val initialScreen: InitialScreen = InitialScreen.NONE_SCREEN
)
