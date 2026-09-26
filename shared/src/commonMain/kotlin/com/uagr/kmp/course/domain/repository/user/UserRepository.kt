/*
 * UserRepository.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.repository.user

import com.uagr.kmp.course.domain.model.user.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUserAndDelete(user: UserModel): Flow<Unit>
    suspend fun saveUserToken(token: String): Flow<Unit>
}
