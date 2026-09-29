/*
 * TransactionsNetworkDataSourceImp.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.transactions

import com.uagr.kmp.course.data.network.model.response.transactions.TransactionsResponse
import com.uagr.kmp.course.domain.mapper.transations.toDomain
import com.uagr.kmp.course.domain.model.transations.TransactionsDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class TransactionsNetworkDataSourceImp(
    private val httpClient: HttpClient
) : TransactionsNetworkDataSource {
    
    override suspend fun getTransactions(
        accountId: String,
        url: String,
    ): NetworkResult<TransactionsDataModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url){
                    contentType(type = ContentType.Application.Json)
                    url{
                        parameters.append("sort", "-transaction_date")
                        parameters.append("accountId", accountId)
                    }
                }
            },
            transform = { data : TransactionsResponse ->
                data.toDomain()
            }
        )
}