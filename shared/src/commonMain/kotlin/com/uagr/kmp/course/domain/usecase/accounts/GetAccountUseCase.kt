/*
 * GetAccountUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.accounts

import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.model.packages.PackagesModel
import com.uagr.kmp.course.domain.repository.accounts.AccountsRepository
import com.uagr.kmp.course.domain.repository.packages.PackagesRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.packages.filterActivePackages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Factory

@Factory
class GetAccountUseCase(
    private val accountsRepository: AccountsRepository
) {

    suspend operator fun invoke(url : String): Flow<NetworkResult<AccountModel>> =
        accountsRepository.getAccount(url = url)
    
}
