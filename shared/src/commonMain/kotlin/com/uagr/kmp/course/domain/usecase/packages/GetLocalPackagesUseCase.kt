/*
 * GetLocalPackagesUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.packages

import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.repository.packages.PackagesRepository
import com.uagr.kmp.course.utils.packages.filterActivePackages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Factory

@Factory
class GetLocalPackagesUseCase(
    private val packagesRepository: PackagesRepository,
) {

    suspend operator fun invoke(): Flow<List<PackagesDataModel>> =
        packagesRepository.getLocalPackages()
            .map { packages -> filterActivePackages(packages = packages) }
}
