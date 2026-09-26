/*
 * AppDataStore.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.uagr.kmp.course.utils.constant.Constants
import okio.Path.Companion.toPath
import org.koin.mp.KoinPlatform.getKoin

actual fun createDataStore(): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath(
        produceFile = {
            val context: Context = getKoin().get()
            context.filesDir.resolve(relative = "${Constants.DATASTORE_NAME}.preferences_pb").absolutePath.toPath()
        },
    )
