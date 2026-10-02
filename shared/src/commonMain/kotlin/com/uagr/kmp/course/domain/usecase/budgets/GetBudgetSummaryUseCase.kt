/*
 * GetBudgetSummaryUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.budgets

import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.repository.budgets.BudgetsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetBudgetSummaryUseCase(
    private val budgetsRepository: BudgetsRepository
) {
    suspend operator fun invoke(url : String): Flow<NetworkResult<BudgetSummaryModel>> =
        budgetsRepository.getBudgetSummary(url = url)
}
