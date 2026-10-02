/*
 * GetAccountsUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.budgets

import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.domain.repository.accounts.AccountsRepository
import com.uagr.kmp.course.domain.repository.budgets.BudgetsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetBudgetsUseCase(
    private val budgetsRepository: BudgetsRepository
) {
    suspend operator fun invoke(url : String): Flow<NetworkResult<BudgetsModel>> =
        budgetsRepository.getBudgets(url = url)
}
