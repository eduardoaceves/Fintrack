/*
 * FlowUtils.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.flow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <T> StateFlow<T>.CollectWithLifecycle(
    vararg keys: Any?,
    action: suspend (T) -> Unit,
) {
    LaunchedEffect(this, *keys) {
        this@CollectWithLifecycle.collectLatest { value ->
            action(value)
        }
    }
}
