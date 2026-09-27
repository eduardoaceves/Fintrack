package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

@Serializable
data class DetailsDataResponse(
    val message: String? = "",
    val type: String? = "",
    val loc: List<String>?,
)