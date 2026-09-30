package com.uagr.kmp.course.data.network.model.response.transactions

import kotlinx.serialization.Serializable

@Serializable
data class TransactionItemResponse(
	val transaction_date: String?,
	val amount: String?,
	val account_id: String?,
	val notes: String?,
	val category_id: String?,
	val updated_at: String?,
	val description: String?,
	val created_at: String?,
	val currency: String?,
	val id: String?,
	val type: String?,
	val version: Int?
)
