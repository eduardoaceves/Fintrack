/*
 * NetworkClient.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.client

import com.uagr.kmp.course.data.local.datastore.AppDataStore
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.constant.NetworkUrl
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json

actual fun createHttpClient(appDataStore: AppDataStore): HttpClient = HttpClient(engineFactory = OkHttp) {

    install(plugin = HttpTimeout) {
        requestTimeoutMillis = Constants.REQUEST_TIMEOUT_MILLIS
        connectTimeoutMillis = Constants.CONNECT_TIMEOUT_MILLIS
        socketTimeoutMillis = Constants.SOCKET_TIMEOUT_MILLIS
    }

    install(plugin = Auth) {
        bearer {
            loadTokens {
                val token = appDataStore.userToken.first()
                if (!token.isNullOrBlank()) {
                    BearerTokens(
                        accessToken = token,
                        refreshToken = "",
                    )
                } else {
                    null
                }
            }
        }
    }

    install(plugin = Logging) {
        level = LogLevel.BODY
    }

    install(plugin = ContentNegotiation) {
        json(
            json = Json { ignoreUnknownKeys = true },
            contentType = ContentType.Application.Json,
        )
    }

    defaultRequest {
        url(urlString = NetworkUrl.BASE_URL)
    }

    engine {
        addInterceptor(interceptor = OkHttpProfilerInterceptor())
    }
}
