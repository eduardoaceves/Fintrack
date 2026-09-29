package com.uagr.kmp.course.data.repository.transactions

import com.uagr.kmp.course.data.network.datasource.transactions.TransactionsNetworkDataSource
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.domain.repository.transactions.TransactionsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class TransactionsRepositoryImp(
    private val transactionsNetworkDataSource: TransactionsNetworkDataSource,
    private val dispatcher: CoroutineDispatcher
) : TransactionsRepository {
    
    override suspend fun getTransactions(
        accountId: String,
        url: String,
    ): Flow<NetworkResult<TransactionsDataModel>> = flow {
        emit(transactionsNetworkDataSource.getTransactions(
            accountId = accountId,
            url = url
        ))
    }.flowOn(context = dispatcher)
    
}