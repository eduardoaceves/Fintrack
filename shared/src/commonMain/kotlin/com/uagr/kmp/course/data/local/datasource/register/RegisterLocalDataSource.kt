package com.uagr.kmp.course.data.local.datasource.register

import com.uagr.kmp.course.domain.model.user.UserDataModel

interface RegisterLocalDataSource {

    suspend fun insertUser(user : UserDataModel)
    
    suspend fun saveUserToken(token: String)

}