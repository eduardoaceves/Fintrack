/*
 * LoginRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.login

import com.uagr.kmp.course.data.network.datasource.login.LoginNetworkDataSource
import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.user.UserTokensModel
import com.uagr.kmp.course.domain.repository.login.LoginRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class LoginRepositoryImpl(
    private val loginNetworkDataSource: LoginNetworkDataSource,
    private val dispatcher: CoroutineDispatcher,
): LoginRepository {

    override suspend fun login(
        url: String,
        loginRequest: LoginRequest,
    ): Flow<NetworkResult<UserTokensModel>> = flow {
        emit(
            loginNetworkDataSource.login(
                url = url,
                loginRequest = loginRequest,
            )
        )
    }.flowOn(context = dispatcher)
}
