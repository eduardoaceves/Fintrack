/*
 * BudgetsMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.budgets

import com.uagr.kmp.course.data.network.model.response.budgets.BudgetSummaryResponse
import com.uagr.kmp.course.data.network.model.response.budgets.BudgetsResponse
import com.uagr.kmp.course.data.network.model.response.budgets.BudgetsResponseItem
import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModelItem

fun BudgetSummaryResponse.toDomain(): BudgetSummaryModel =
    BudgetSummaryModel(
        spent = spent.orEmpty(),
        percentage = percentage.orEmpty(),
        remaining = remaining.orEmpty(),
        budget = budget.orEmpty()
    )

fun BudgetsResponse.toDomain(): BudgetsModel =
    BudgetsModel(
        data = data?.map{
                data -> data.toDomain()
        } as List<BudgetsModelItem>
    )

fun BudgetsResponseItem.toDomain(): BudgetsModelItem =
    BudgetsModelItem(
        id = id.orEmpty(),
        category_id = category_id.orEmpty(),
        amount = amount.orEmpty(),
        version = version?:0,
        start_date = start_date.orEmpty()
    )