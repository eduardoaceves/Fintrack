package com.uagr.kmp.course.domain.repository.summary

import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface SummaryRepository {
    
    suspend fun summary(
        accountId : String,
        url : String
    ) : Flow<NetworkResult<SummaryDataModel>>
    
}