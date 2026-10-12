/*
 * UserRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.user

import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    
    suspend fun insertUserAndDelete(user: UserDataModel): Flow<Unit>
    
    suspend fun saveUserToken(token: String): Flow<Unit>
    
    suspend fun saveUserRefreshToken(refreshToken: String): Flow<Unit>
    
    suspend fun getUserInformation() : Flow<UserDataModel>
    
    suspend fun getUserRemoteInformation(url : String) : Flow<NetworkResult<UserDataModel>>
    
    suspend fun deleteAllUsers() : Flow<Unit>
    
}
