/*
 * GetAccountsUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.accounts

import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.accounts.AccountsDataModel
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
class GetAccountsUseCase(
    private val accountsRepository: AccountsRepository
) {

    suspend operator fun invoke(url : String): Flow<NetworkResult<AccountsDataModel>> =
        accountsRepository.getAccounts(url = url)
    
}
