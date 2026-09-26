/*
 * PackagesUtils.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.packages

import com.uagr.kmp.course.domain.model.packages.PackagesDataModel

fun filterActivePackages(packages: List<PackagesDataModel>): List<PackagesDataModel> =
    packages.filter { packages -> packages.stock.toIntOrNull()?.let { stock -> stock > 0 } ?: false }
