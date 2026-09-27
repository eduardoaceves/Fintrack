/*
 * RegisterRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.model.user.UserModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun registerUser(
        url : String,
        registerRequest : RegisterRequest
    ) : Flow<NetworkResult<RegisterDataModel>>
    
}