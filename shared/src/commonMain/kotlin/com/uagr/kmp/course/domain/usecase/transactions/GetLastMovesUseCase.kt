package com.uagr.kmp.course.domain.usecase.transactions

import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.domain.repository.transactions.TransactionsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetLastMovesUseCase(
    private val transactionsRepository: TransactionsRepository
) {
    suspend operator fun invoke(
        accountId : String,
        url : String
    ) : Flow<NetworkResult<TransactionsDataModel>> =
        transactionsRepository.getTransactions(
            accountId = accountId,
            url = url
        )
}