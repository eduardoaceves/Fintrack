/*
 * PackagesModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.packages

data class PackagesDataModel(
    val id: String,
    val name: String,
    val description: String,
    val price: String,
    val currency: String,
    val stock: String,
    val created_by: String,
    val created_at: String,
)
