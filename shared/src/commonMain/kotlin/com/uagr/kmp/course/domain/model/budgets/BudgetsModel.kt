/*
 * BudgetsResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.budgets

import kotlinx.serialization.SerialName

data class BudgetsModel(
    val data : List<BudgetsModelItem>
)

data class BudgetsModelItem(
    val id: String,
    val category_id: String,
    val amount: String,
    val version: Int,
    val start_date: String
)
