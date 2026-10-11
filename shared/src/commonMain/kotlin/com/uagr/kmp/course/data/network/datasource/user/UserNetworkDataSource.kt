/*
 * UserNetworkDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.user

import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface UserNetworkDataSource {

    suspend fun getRemoteUserInformation(
        url : String,
    ) : NetworkResult<UserDataModel>
    
}
