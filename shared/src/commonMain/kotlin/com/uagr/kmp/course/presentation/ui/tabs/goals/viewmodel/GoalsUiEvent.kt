/*
 * GoalsUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.tabs.goals.viewmodel

sealed class GoalsUiEvent {
    internal data object Idle: GoalsUiEvent()
    data object CloseSessionSuccess: GoalsUiEvent()
}