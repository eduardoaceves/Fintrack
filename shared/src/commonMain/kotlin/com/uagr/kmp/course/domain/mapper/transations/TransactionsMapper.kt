/*
 * TransactionsMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.transations

import com.uagr.kmp.course.data.network.model.response.transactions.TransactionItemResponse
import com.uagr.kmp.course.data.network.model.response.transactions.TransactionsResponse
import com.uagr.kmp.course.domain.model.transations.TransactionItemModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel


fun TransactionsResponse.toDomain() : TransactionsDataModel =
    TransactionsDataModel(
        items = items?.map { data -> data.toDomain() } ?: emptyList()
    )

fun TransactionItemResponse.toDomain() : TransactionItemModel =
    TransactionItemModel(
        id = id.orEmpty(),
        transactionDate = transaction_date.orEmpty(),
        amount = amount.orEmpty(),
        accountId = accountId.orEmpty(),
        notes = notes.orEmpty(),
        categoryId = category_id.orEmpty(),
        description = description.orEmpty(),
        currency = currency.orEmpty(),
        type = type.orEmpty()
    )