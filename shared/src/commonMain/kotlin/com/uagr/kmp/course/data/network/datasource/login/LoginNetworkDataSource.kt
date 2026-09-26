/*
 * LoginNetworkDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.login

import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface LoginNetworkDataSource {
    suspend fun login(
        url: String,
        loginRequest: LoginRequest,
    ): NetworkResult<LoginModel>
}
