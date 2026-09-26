/*
 * PackagesRepositoryImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.repository.packages

import com.uagr.kmp.course.data.local.datasource.packages.PackagesLocalDataSource
import com.uagr.kmp.course.data.network.datasource.packages.PackagesNetworkDataSource
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import com.uagr.kmp.course.domain.model.packages.PackagesModel
import com.uagr.kmp.course.domain.repository.packages.PackagesRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Factory

@Factory
class PackagesRepositoryImpl(
    private val packagesNetworkDataSource: PackagesNetworkDataSource,
    private val packagesLocalDataSource: PackagesLocalDataSource,
    private val dispatcher: CoroutineDispatcher,
) : PackagesRepository {

    override suspend fun getNetworkPackages(url: String): Flow<NetworkResult<PackagesModel>> = flow {
        emit(value = packagesNetworkDataSource.getPackages(url = url))
    }.flowOn(context = dispatcher)

    override suspend fun clearAndInsertPackages(packages: List<PackagesDataModel>): Flow<Unit> = flow {
        emit(value = packagesLocalDataSource.clearAndInsertPackages(packages = packages))
    }.flowOn(context = dispatcher)

    override suspend fun getLocalPackages(): Flow<List<PackagesDataModel>> = flow {
        emit(value = packagesLocalDataSource.getPackages())
    }.flowOn(context = dispatcher)
}
