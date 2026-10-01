/*
 * GetLocalAccountIdUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.accounts

import com.uagr.kmp.course.domain.repository.accounts.AccountsRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetLocalAccountIdUseCase(
    private val accountsRepository: AccountsRepository
) {

    suspend operator fun invoke(): Flow<String> =
        accountsRepository.getAccountId()
    
}
