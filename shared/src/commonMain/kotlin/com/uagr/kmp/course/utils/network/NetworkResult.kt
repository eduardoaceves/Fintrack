/*
 * NetworkResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.network

sealed class NetworkResult<out T> {
    data class Success<T>(val response: T) : NetworkResult<T>()
    data class Error(
        val message: String,
        val code: Int? = null,
        val errorType: NetworkErrorType = NetworkErrorType.UNKNOWN,
        val data: Any? = null,
    ) : NetworkResult<Nothing>()
}

enum class NetworkErrorType {
    TIMEOUT,
    NETWORK,
    HTTP,
    UNKNOWN,
}
