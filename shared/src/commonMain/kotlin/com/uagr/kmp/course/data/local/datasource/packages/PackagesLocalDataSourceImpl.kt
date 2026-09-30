/*
 * PackagesLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.packages

import com.uagr.kmp.course.data.local.database.dao.packages.PackagesDao
import com.uagr.kmp.course.domain.mapper.packages.toDomain
import com.uagr.kmp.course.domain.mapper.packages.toEntity
import com.uagr.kmp.course.domain.model.packages.PackagesDataModel
import org.koin.core.annotation.Factory

@Factory
class PackagesLocalDataSourceImpl(
    private val packagesDao: PackagesDao
) : PackagesLocalDataSource {

    override suspend fun clearAndInsertPackages(packages: List<PackagesDataModel>) {
        packagesDao.clearAndInsertPackages(
            packages = packages.map {
                data  -> data.toEntity()
            })
    }
    
    override suspend fun getPackages(): List<PackagesDataModel> =
        packagesDao.getPackages().map { data -> data.toDomain() }
}
