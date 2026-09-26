/*
 * ClearAndInsertPackagesUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.packages

import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.repository.packages.PackagesRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class ClearAndInsertPackagesUseCase(
    private val packagesRepository: PackagesRepository,
) {
    suspend operator fun invoke(packages: List<PackagesDataModel>): Flow<Unit> =
        packagesRepository.clearAndInsertPackages(packages = packages)
}
