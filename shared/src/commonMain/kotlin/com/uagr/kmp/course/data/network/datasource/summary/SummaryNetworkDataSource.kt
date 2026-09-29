package com.uagr.kmp.course.data.network.datasource.summary

import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import io.ktor.http.Url

interface SummaryNetworkDataSource {

    suspend fun getSummary(
        accountId : String,
        url: String
    ) : NetworkResult<SummaryDataModel>

}