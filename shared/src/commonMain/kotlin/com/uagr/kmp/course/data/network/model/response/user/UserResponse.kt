/*
 * UserResponse.kt
 * Copyright (c) 2026. All rights reserved
 */

package com.uagr.kmp.course.data.network.model.response.user

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val is_active: Boolean?,
    val email_verified: Boolean?,
    val updated_at: String?,
    val timezone: String?,
    val name: String?,
    val created_at: String?,
    val currency: String?,
    val id: String?,
    val locale: String?,
    val email: String?,
) : BaseResponse()