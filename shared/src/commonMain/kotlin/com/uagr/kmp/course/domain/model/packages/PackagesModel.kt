/*
 * PackagesModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.packages

data class PackagesModel(
    val data: List<PackagesDataModel>,
    val success: Boolean,
    val message: String,
)
