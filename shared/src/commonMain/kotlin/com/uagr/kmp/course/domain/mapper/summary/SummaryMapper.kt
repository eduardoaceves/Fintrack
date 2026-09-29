package com.uagr.kmp.course.domain.mapper.summary

import com.uagr.kmp.course.data.network.model.response.summary.SummaryResponse
import com.uagr.kmp.course.domain.model.summary.SummaryDataModel

fun SummaryResponse.toDomain() : SummaryDataModel =
    SummaryDataModel(
        income = income.orEmpty(),
        expenses = expenses.orEmpty(),
        net = net.orEmpty()
    )