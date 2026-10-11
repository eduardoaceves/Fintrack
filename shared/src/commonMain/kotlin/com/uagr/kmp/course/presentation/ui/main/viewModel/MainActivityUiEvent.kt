/*
 * MainActivityUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.main.viewModel

sealed class MainActivityUiEvent {
    internal data object Idle: MainActivityUiEvent()
    data object UserLogged: MainActivityUiEvent()
    data object UserNotLogged: MainActivityUiEvent()
}
