/*
 * NetworkClient.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.client

import com.uagr.kmp.course.data.local.datastore.AppDataStore
import io.ktor.client.HttpClient

expect fun createHttpClient(appDataStore: AppDataStore): HttpClient
