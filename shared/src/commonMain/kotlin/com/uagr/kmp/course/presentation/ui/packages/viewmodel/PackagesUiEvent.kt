/*
 * PackagesUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.packages.viewmodel

import org.jetbrains.compose.resources.StringResource

sealed class PackagesUiEvent {
    internal data object Idle: PackagesUiEvent()
    internal data class ShowErrorDialog(val message: StringResource): PackagesUiEvent()
    internal data class ShowErrorStringDialog(val message: String): PackagesUiEvent()
}
