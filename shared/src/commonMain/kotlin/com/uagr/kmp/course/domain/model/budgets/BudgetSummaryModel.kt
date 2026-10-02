/*
 * BudgetSummaryModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.budgets

data class BudgetSummaryModel(
	val spent: String,
	val percentage: String,
	val remaining: String,
	val budget: String
)

