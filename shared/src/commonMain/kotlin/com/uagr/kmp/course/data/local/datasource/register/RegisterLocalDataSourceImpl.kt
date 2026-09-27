/*
 * RegisterLocalDataSourceImpl.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.local.datasource.register

import com.uagr.kmp.course.data.local.database.dao.user.UserDao
import com.uagr.kmp.course.data.local.datastore.AppDataStore
import com.uagr.kmp.course.domain.mapper.user.toEntity
import com.uagr.kmp.course.domain.model.user.UserDataModel
import org.koin.core.annotation.Factory

@Factory
class RegisterLocalDataSourceImpl(
    private val userDao: UserDao,
    private val appDataStore: AppDataStore
) : RegisterLocalDataSource {
    
    override suspend fun insertUser(user: UserDataModel) {
        userDao.insertUser(user = user.toEntity())
    }
    
    override suspend fun saveUserToken(token: String) =
        appDataStore.saveUserToken(token = token)
    
}