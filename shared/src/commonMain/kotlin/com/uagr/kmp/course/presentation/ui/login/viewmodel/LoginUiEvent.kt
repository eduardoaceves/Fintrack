/*
 * LoginUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.viewmodel

sealed class LoginUiEvent {
    internal data object Idle: LoginUiEvent()
    data object LoginSuccess: LoginUiEvent()
}
