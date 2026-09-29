/*
 * TransactionsNetworkDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.transactions

import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface TransactionsNetworkDataSource {

    suspend fun getTransactions(
        accountId : String,
        url: String
    ) : NetworkResult<TransactionsDataModel>

}