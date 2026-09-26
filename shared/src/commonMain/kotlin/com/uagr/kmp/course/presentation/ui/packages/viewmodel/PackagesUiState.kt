/*
 * PackagesUiState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.packages.viewmodel

import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class PackagesUiState(
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val packages: List<PackagesDataModel> = emptyList(),
)
