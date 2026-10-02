/*
 * BudgetSummaryResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.budgets

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class BudgetSummaryResponse(
	val spent: String?,
	val percentage: String?,
	val remaining: String?,
	val budget: String?
) : BaseResponse()

