package com.uagr.kmp.course.data.network.model.response.transactions

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import com.uagr.kmp.course.data.network.model.response.base.Pagination
import kotlinx.serialization.Serializable

@Serializable
data class TransactionsResponse(
	val pagination: Pagination?,
	val items: List<TransactionItemResponse>?
) : BaseResponse()
