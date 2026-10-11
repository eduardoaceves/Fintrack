/*
 * NetworkClient.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.client

import android.media.session.MediaSession
import com.uagr.kmp.course.data.local.datastore.AppDataStore
import com.uagr.kmp.course.data.network.model.request.refreshToken.RefreshTokenRequest
import com.uagr.kmp.course.data.network.model.response.register.TokenDataResponse
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.HttpExceptions
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.parameters
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
            refreshTokens {
                val oldRefreshToken = appDataStore.refreshToken.first().orEmpty()
                val refreshToken : TokenDataResponse = client.submitForm {
                    url(urlString = NetworkUrl.BASE_URL + NetworkUrl.REFRESH_TOKENS_ENDPOINT)
                    contentType(type = ContentType.Application.Json)
                    setBody(body = RefreshTokenRequest(refresh_token = oldRefreshToken))
                    markAsRefreshTokenRequest()
                }.body<TokenDataResponse>()
                appDataStore.saveUserToken(refreshToken.access_token.orEmpty())
                appDataStore.saveRefreshToken(refreshToken.refresh_token.orEmpty())
                BearerTokens(
                    accessToken = refreshToken.access_token.orEmpty(),
                    refreshToken = refreshToken.refresh_token.orEmpty(),
                )
            }
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
            json = Json {
                ignoreUnknownKeys = true
                explicitNulls = false
            },
            contentType = ContentType.Application.Json,
        )
    }

    defaultRequest {
        url(urlString = NetworkUrl.BASE_URL)
    }
    
    /*HttpResponseValidator {
        validateResponse { response ->
            if(!response.status.isSuccess()) {
                val httpFailureReason = when (response.status) {
                    HttpStatusCode.Unauthorized -> "Unauthorized"
                    HttpStatusCode.Forbidden -> "${response.status.value} Missing API key"
                    HttpStatusCode.NotFound -> "Invalid Request"
                    else -> "Unknown error"
                }
                throw HttpExceptions(
                    response = response,
                    failureReason = httpFailureReason,
                    cachedResponseText = response.bodyAsText()
                )
            }
        }
    }*/
    
    engine {
        addInterceptor(interceptor = OkHttpProfilerInterceptor())
    }
}
