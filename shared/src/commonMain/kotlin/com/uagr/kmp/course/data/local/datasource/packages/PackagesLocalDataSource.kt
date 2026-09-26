/*
 * PackagesLocalDataSource.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.packages

import com.uagr.kmp.course.domain.model.packages.PackagesDataModel

interface PackagesLocalDataSource {
    suspend fun clearAndInsertPackages(packages: List<PackagesDataModel>)
    suspend fun getPackages(): List<PackagesDataModel>
}
