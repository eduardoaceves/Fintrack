/*
 * PackagesNetworkDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.packages

import com.uagr.kmp.course.data.network.model.response.packages.PackagesResponse
import com.uagr.kmp.course.domain.mapper.packages.toDomain
import com.uagr.kmp.course.domain.model.packages.PackagesModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class PackagesNetworkDataSourceImpl(
    private val httpClient: HttpClient,
) : PackagesNetworkDataSource {

    override suspend fun getPackages(url: String): NetworkResult<PackagesModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data: PackagesResponse ->
                data.toDomain()
            },
        )
}
