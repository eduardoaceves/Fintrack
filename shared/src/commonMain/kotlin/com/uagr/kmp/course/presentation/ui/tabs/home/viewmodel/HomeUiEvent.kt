/*
 * HomeUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.home.viewmodel

sealed class HomeUiEvent {
    internal data object Idle: HomeUiEvent()
    data object AccountsSuccess: HomeUiEvent()
}