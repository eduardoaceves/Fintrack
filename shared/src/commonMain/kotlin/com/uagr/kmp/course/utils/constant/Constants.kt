/*
 * Constants.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.constant

object Constants {
    const val REQUEST_TIMEOUT_MILLIS = 15000L
    const val CONNECT_TIMEOUT_MILLIS = 10000L
    const val SOCKET_TIMEOUT_MILLIS  = 10000L
    const val EMAIL_PATTERN = "[a-zA-Z\\d._-]+@[a-z]+\\.+[a-z]+"
    const val DATABASE_NAME = "kmp_course_DB"
    const val USER_TOKEN = "user_token"
    const val REFRESH_TOKEN = "refresh_token"
    const val ACCOUNT_ID = "account_id"
    const val DATASTORE_NAME = "kmp_dataStore"
    const val PASSWORD_LENGTH = 20
    const val EMAIL_LENGTH = 60
    const val NAME_LENGTH = 30
    const val TRANSACTION_ALL = ""
    const val TRANSACTION_INCOME = "INCOME"
    const val TRANSACTION_EXPEND = "EXPENSE"
    const val DEVICE_ID = "4a4e2dcd-f217-4b7c-b4fb-70b0ee84a6c2"
}
