package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    val total: Int?,
    val pages: Int?,
    val page: Int?,
    val pageSize: Int?
)
