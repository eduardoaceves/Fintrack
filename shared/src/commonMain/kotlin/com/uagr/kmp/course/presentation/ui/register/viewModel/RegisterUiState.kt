/*
 * RegisterUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.register.viewModel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class RegisterUiState(
    val name: String = "",
    val nameError: String = "",
    val email: String = "",
    val emailError: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val passwordError: String = "",
    val confirmPassword: String = "",
    val confirmPasswordVisible: Boolean = false,
    val confirmPasswordError: String = "",
    val errorDialog: ErrorDialogModel? = null,
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
)
