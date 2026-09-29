/*
 * GetAccountUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.summary

import com.uagr.kmp.course.domain.model.accounts.AccountModel
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.model.packages.PackagesModel
import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.domain.repository.accounts.AccountsRepository
import com.uagr.kmp.course.domain.repository.packages.PackagesRepository
import com.uagr.kmp.course.domain.repository.summary.SummaryRepository
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.packages.filterActivePackages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Factory

@Factory
class SummaryUseCase(
    private val summaryRepository: SummaryRepository
) {

    suspend operator fun invoke(
        accountId : String,
        url : String): Flow<NetworkResult<SummaryDataModel>> =
        summaryRepository.summary(
            accountId = accountId,
            url = url
        )
    
}
