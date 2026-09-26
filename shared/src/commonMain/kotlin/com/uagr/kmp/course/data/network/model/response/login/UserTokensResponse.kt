/*
 * UserTokensResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.login

import kotlinx.serialization.Serializable

@Serializable
data class UserTokensResponse(
    val token_type: String?,
    val access_token: String?,
    val refresh_token: String?,
    val expires_in: Int?,
)
