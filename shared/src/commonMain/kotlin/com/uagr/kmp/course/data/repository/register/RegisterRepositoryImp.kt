/*
 * RegisterRepositoryImp.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.register

import com.uagr.kmp.course.data.local.datasource.register.RegisterLocalDataSource
import com.uagr.kmp.course.data.network.datasource.register.RegisterNetworkDataSource
import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.repository.register.RegisterRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class RegisterRepositoryImp(
    private val registerNetworkDataSource: RegisterNetworkDataSource,
    private val registerLocalDataSource: RegisterLocalDataSource,
    private val dispatcher: CoroutineDispatcher,
) : RegisterRepository {
    
    override suspend fun registerUser(
        url: String,
        registerRequest: RegisterRequest,
    ): Flow<NetworkResult<RegisterDataModel>> = flow {
        emit(
            registerNetworkDataSource.registerUser(
                url = url,
                registerRequest = registerRequest,
            )
        )
    }.flowOn(context = dispatcher)
}
