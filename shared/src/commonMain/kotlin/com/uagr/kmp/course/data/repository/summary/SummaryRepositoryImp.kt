package com.uagr.kmp.course.data.repository.summary

import com.uagr.kmp.course.data.network.datasource.summary.SummaryNetworkDataSource
import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.domain.repository.summary.SummaryRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class SummaryRepositoryImp(
    private val summaryNetworkDataSource: SummaryNetworkDataSource,
    private val dispatcher: CoroutineDispatcher
) : SummaryRepository {
    
    override suspend fun summary(
        accountId : String,
        url : String
    ): Flow<NetworkResult<SummaryDataModel>> = flow{
        emit(
            summaryNetworkDataSource.getSummary(
                accountId = accountId,
                url = url
            )
        )
    }.flowOn(context = dispatcher)
}