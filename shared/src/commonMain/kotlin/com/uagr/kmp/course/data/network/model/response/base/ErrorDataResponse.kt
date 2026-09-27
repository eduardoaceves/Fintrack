package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

@Serializable
data class ErrorDataResponse(
    val code: String? = "",
    val message: String? = "",
    val details: List<DetailsDataResponse>?,
)