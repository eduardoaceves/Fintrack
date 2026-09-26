/*
 * KoinInitializer.kt
 * Copyright (c) 2026. All rights reserved
*/
package com.uagr.kmp.course.di

import org.koin.dsl.KoinAppDeclaration
import org.koin.plugin.module.dsl.startKoin

fun initKoin(
    config: KoinAppDeclaration? = null,
) {
    startKoin<MainApp> {
        config?.invoke(this)
    }
}
