/*
 * ColorStatus
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorStatus(
    val error: Color = Color.Unspecified,
    val errorContainer: Color = Color.Unspecified,
    val warning: Color = Color.Unspecified,
    val warningContainer: Color = Color.Unspecified,
    val info: Color = Color.Unspecified,
    val infoContainer: Color = Color.Unspecified,
    val success: Color = Color.Unspecified,
    val successContainer: Color = Color.Unspecified,
)
