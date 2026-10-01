/*
 * TransactionItemModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.transations

data class TransactionsLazyRowModel(
	val transactions : List<TransactionsLazyRowObject>
)

data class TransactionsLazyRowObject(
	val date : String,
	val items : List<TransactionLazyRowItem>
)

data class TransactionLazyRowItem(
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

