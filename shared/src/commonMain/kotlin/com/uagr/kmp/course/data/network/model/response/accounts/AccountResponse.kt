/*
 * AccountResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.accounts

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class AccountResponse(
    val is_active: Boolean?,
    val color: String?,
    val updated_at: String?,
    val name: String?,
    val icon: String?,
    val current_balance: String?,
    val created_at: String?,
    val currency: String?,
    val id: String?,
    val type: String?,
    val version: Int?,
    val initial_balance: String?
) : BaseResponse()
