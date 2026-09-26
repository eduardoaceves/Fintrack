/*
 * RegisterNetworkDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface RegisterNetworkDataSource {
    suspend fun registerUser(
        url : String,
        registerRequest: RegisterRequest)
    : NetworkResult<RegisterDataModel>
}