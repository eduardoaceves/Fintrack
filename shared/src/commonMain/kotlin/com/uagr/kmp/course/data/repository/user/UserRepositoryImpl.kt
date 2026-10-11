/*
 * UserRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.user

import com.uagr.kmp.course.data.local.datasource.user.UserLocalDataSource
import com.uagr.kmp.course.data.network.datasource.user.UserNetworkDataSource
import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.repository.user.UserRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class UserRepositoryImpl(
    private val userNetworkDataSource: UserNetworkDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher,
): UserRepository {

    override suspend fun insertUserAndDelete(user: UserDataModel): Flow<Unit> = flow {
        emit(userLocalDataSource.insertUserAndDelete(user = user))
    }.flowOn(context = ioDispatcher)

    override suspend fun saveUserToken(token: String): Flow<Unit> = flow {
        emit(userLocalDataSource.saveUserToken(token = token))
    }.flowOn(context = ioDispatcher)
    
    override suspend fun saveUserRefreshToken(refreshToken: String): Flow<Unit> = flow {
        emit(userLocalDataSource.saveRefreshToken(refreshToken = refreshToken))
    }.flowOn(context = ioDispatcher)
    
    override suspend fun getUserInformation(): Flow<UserDataModel> = flow {
        emit(value = userLocalDataSource.getUser())
    }.flowOn(context = ioDispatcher)
    
    override suspend fun getUserRemoteInformation(
        url : String
    ): Flow<NetworkResult<UserDataModel>> = flow {
        emit(
            value = userNetworkDataSource.getRemoteUserInformation(
                url = url
            )
        )
    }.flowOn(context = ioDispatcher)
    
    
}
