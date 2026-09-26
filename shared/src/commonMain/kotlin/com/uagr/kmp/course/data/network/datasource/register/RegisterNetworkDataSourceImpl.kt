/*
 * RegisterNetworkDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.data.network.model.response.register.RegisterDataResponse
import com.uagr.kmp.course.domain.mapper.login.toDomain
import com.uagr.kmp.course.domain.mapper.register.toDomain
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.domain.model.user.UserModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class RegisterNetworkDataSourceImpl(
    private val httpClient: HttpClient
) : RegisterNetworkDataSource {
    override suspend fun registerUser(
        url: String,
        registerRequest: RegisterRequest,
    ): NetworkResult<RegisterDataModel> =
        safeApiCall(
            apiCall = {
                httpClient.post(urlString = url){
                    contentType(type = ContentType.Application.Json)
                    setBody(body = registerRequest)
                }
            },
            transform = {  data : RegisterDataResponse ->
                data.toDomain()
            },
        )
    
}