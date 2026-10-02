/*
 * BudgetsRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.budgets

import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface BudgetsRepository {
    
    suspend fun getBudgetSummary(url : String) : Flow<NetworkResult<BudgetSummaryModel>>
    
    suspend fun getBudgets(url : String) : Flow<NetworkResult<BudgetsModel>>
    
}