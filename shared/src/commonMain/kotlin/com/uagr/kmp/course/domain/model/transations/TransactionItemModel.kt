/*
 * TransactionItemModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.transations

data class TransactionItemModel(
	val id: String,
	val transactionDate: String,
	val amount: String,
	val accountId: String,
	val notes: String,
	val categoryId: String,
	val description: String,
	val currency: String,
	val type: String,
)

