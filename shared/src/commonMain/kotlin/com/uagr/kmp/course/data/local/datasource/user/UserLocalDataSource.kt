/*
 * UserLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.user

import com.uagr.kmp.course.domain.model.user.UserDataModel

interface UserLocalDataSource {
    suspend fun insertUserAndDelete(user: UserDataModel)
    suspend fun saveUserToken(token: String)
}
