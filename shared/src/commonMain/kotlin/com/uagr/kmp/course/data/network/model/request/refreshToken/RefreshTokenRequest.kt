package com.uagr.kmp.course.data.network.model.request.refreshToken

import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequest(
    val refresh_token: String
)