/*
 * UserLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.user

import com.uagr.kmp.course.data.network.model.response.user.UserResponse
import com.uagr.kmp.course.domain.mapper.user.toDomain
import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class UserNetworkDataSourceImpl(
    private val httpClient : HttpClient,
): UserNetworkDataSource {
    
    override suspend fun getRemoteUserInformation(url: String) : NetworkResult<UserDataModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: UserResponse ->
                data.toDomain()
            },
        )
    
    
}
