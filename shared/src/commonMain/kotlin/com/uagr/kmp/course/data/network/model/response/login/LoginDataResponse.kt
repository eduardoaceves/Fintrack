/*
 * LoginDataResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginDataResponse(
    val user: UserResponse?,
    val tokens: UserTokensResponse?,
)
