/*
 * LoginUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class LoginUiState(
    val email : String = "",
    val emailError : String = "",
    val password : String = "",
    val passwordError : String = "",
    val passwordVisible : Boolean = false,
    val errorDialog : ErrorDialogModel? = null,
    val isLoading : StatusLoading = StatusLoading.DISMISS_LOADING,
)
