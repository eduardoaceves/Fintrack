package com.uagr.kmp.course.domain.model.transations

data class TransactionModel(
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

