/*
 * BudgetsResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.budgets

import androidx.room3.Ignore
import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class BudgetsResponse(
    @Ignore
    val data: List<BudgetsItemResponse>?
) : BaseResponse()

@Serializable
data class BudgetsItemResponse(
    val id: String?,
    val category_id: String?,
    val amount: String?,
    val period: String?,
    val start_date: String?,
    val end_date: String?,
    val created_at: String?,
    val updated_at: String?,
    val version: Int?,
    
)
