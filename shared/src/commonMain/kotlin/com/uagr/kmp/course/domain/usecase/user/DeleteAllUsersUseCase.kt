/*
 * DeleteAllUsersUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.user

import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.repository.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class DeleteAllUsersUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): Flow<Unit> =
        userRepository.deleteAllUsers()

}
