package com.uagr.kmp.course.domain.repository.transactions

import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface TransactionsRepository {
    
    suspend fun getTransactions(
        accountId : String,
        url : String
    ) : Flow<NetworkResult<TransactionsDataModel>>
    
}