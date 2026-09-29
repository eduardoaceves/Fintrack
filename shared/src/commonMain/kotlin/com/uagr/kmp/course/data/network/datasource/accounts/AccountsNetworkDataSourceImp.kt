/*
 * AccountsNetworkDataSourceImp.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.accounts

import com.uagr.kmp.course.data.network.model.response.accounts.AccountResponse
import com.uagr.kmp.course.data.network.model.response.accounts.AccountsResponse
import com.uagr.kmp.course.domain.mapper.accounts.toDomain
import com.uagr.kmp.course.domain.mapper.login.toDomain
import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class AccountsNetworkDataSourceImp(
    private val httpClient: HttpClient
) : AccountsNetworkDataSource {
    
    override suspend fun getAccounts(url: String): NetworkResult<AccountsDataModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data : AccountsResponse->
                data.toDomain()
            }
        )
    
    override suspend fun getAccount(url: String): NetworkResult<AccountModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: AccountResponse ->
                data.toDomain()
            }
        )
}