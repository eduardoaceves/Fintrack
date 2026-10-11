package com.uagr.kmp.course.domain.usecase.main

import com.uagr.kmp.course.domain.model.user.UserDataModel
import com.uagr.kmp.course.domain.repository.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class ValidateInitialScreenUseCase(
    private val userRepository: UserRepository,
) {
    suspend fun getUserInformation() : Flow<UserDataModel> = userRepository.getUserInformation()
}