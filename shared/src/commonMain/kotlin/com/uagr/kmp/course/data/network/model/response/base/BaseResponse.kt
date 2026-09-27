/*
 * BaseResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse(
    val success: Boolean? = true,
    val message: String? = "",
    val error : ErrorDataResponse? = ErrorDataResponse(
        code = "",
        message = "",
        details = null
    )
)
