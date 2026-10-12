/*
 * FilterResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.transactions

sealed class FilterResult {
    data object FilteredFinish : FilterResult()
    data object Success : FilterResult()
}
