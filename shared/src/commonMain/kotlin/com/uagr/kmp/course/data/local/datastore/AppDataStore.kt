/*
 * AppDataStore.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.uagr.kmp.course.utils.constant.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.io.IOException
import org.koin.core.annotation.Single

@Single
class AppDataStore(
    private val dataStore: DataStore<Preferences>,
) {
    object KEY {
        val USER_TOKEN = stringPreferencesKey(name = Constants.USER_TOKEN)
    }

    val userToken: Flow<String?> = dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences()) else throw exception
        }.map { data -> data[KEY.USER_TOKEN] }

    suspend fun saveUserToken(token: String) {
        dataStore.edit { data -> data[KEY.USER_TOKEN] = token }
    }
}

expect fun createDataStore(): DataStore<Preferences>
