package com.uagr.kmp.course.data.network.model.request.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String,
)