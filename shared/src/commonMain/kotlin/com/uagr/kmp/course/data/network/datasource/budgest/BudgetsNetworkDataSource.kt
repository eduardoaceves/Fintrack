/*
 * BudgetsNetworkDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.budgest

import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface BudgetsNetworkDataSource {
    suspend fun getBudgetSummary(
        url: String,
    ): NetworkResult<BudgetSummaryModel>
    
    suspend fun getBudgets(
        url: String,
    ): NetworkResult<BudgetsModel>
}
