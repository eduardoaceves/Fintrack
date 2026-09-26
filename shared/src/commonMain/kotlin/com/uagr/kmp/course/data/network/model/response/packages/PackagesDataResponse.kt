/*
 * PackagesDataResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.packages

import kotlinx.serialization.Serializable

@Serializable
data class PackagesDataResponse(
    val id: String?,
    val sku: String?,
    val name: String?,
    val description: String?,
    val category: String?,
    val price: Double?,
    val currency: String?,
    val stock: Int?,
    val image_url: String?,
    val is_active: Boolean?,
    val created_by: String?,
    val created_at: String?,
    val updated_at: String?,
)
