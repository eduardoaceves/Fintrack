/*
 * BudgetsResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.budgets

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import com.uagr.kmp.course.data.network.model.response.packages.PackagesDataResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class BudgetsResponse(
    val data: List<BudgetsResponseItem>?,
) : BaseResponse()

@Serializable
data class BudgetsResponseItem(
    val id: String?,
    val category_id: String?,
    val amount: String?,
    val period: String?,
    val start_date: String?,
    val end_date: String?,
    val created_at: String?,
    val updated_at: String?,
    val version: Int?,
    
) : BaseResponse()
