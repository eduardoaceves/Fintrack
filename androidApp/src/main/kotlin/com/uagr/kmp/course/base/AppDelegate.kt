/*
 * AppDelegate.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.base

import android.app.Application
import com.uagr.kmp.course.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class AppDelegate : Application() {
    override fun onCreate() {
        super.onCreate()
        // DI KMP
        initKoin(
            config = {
                androidLogger(Level.DEBUG)
                androidContext(this@AppDelegate)
            },
        )
    }
}
