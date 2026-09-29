/*
 * LoginRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.login

import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.user.UserTokensModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(
        url: String,
        loginRequest: LoginRequest,
    ): Flow<NetworkResult<UserTokensModel>>
}
