/*
 * LoginResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.login

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse (
    val data: LoginDataResponse?,
) : BaseResponse()
