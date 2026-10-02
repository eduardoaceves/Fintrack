/*
 * BudgetsRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.budgets

import com.uagr.kmp.course.data.network.datasource.budgest.BudgetsNetworkDataSource
import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.domain.repository.budgets.BudgetsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class BudgetsRepositoryImpl(
    private val budgetsNetworkDataSource: BudgetsNetworkDataSource,
    private val dispatcher: CoroutineDispatcher
) : BudgetsRepository {
    
    override suspend fun getBudgetSummary(url: String): Flow<NetworkResult<BudgetSummaryModel>>  = flow{
        emit( value = budgetsNetworkDataSource.getBudgetSummary(url = url))
    }.flowOn(context = dispatcher)
    
    override suspend fun getBudgets(url: String): Flow<NetworkResult<BudgetsModel>> = flow{
        emit( value = budgetsNetworkDataSource.getBudgets(url = url))
    }.flowOn(context = dispatcher)
    
}