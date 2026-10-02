/*
 * BudgetsNetworkDataSourceImp.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.datasource.budgest

import com.uagr.kmp.course.data.network.model.response.budgets.BudgetSummaryResponse
import com.uagr.kmp.course.data.network.model.response.budgets.BudgetsResponse
import com.uagr.kmp.course.domain.mapper.budgets.toDomain
import com.uagr.kmp.course.domain.model.budgets.BudgetSummaryModel
import com.uagr.kmp.course.domain.model.budgets.BudgetsModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class BudgetsNetworkDataSourceImp(
    private val httpClient: HttpClient
) : BudgetsNetworkDataSource {
    override suspend fun getBudgetSummary(url: String): NetworkResult<BudgetSummaryModel> =
      safeApiCall(
          apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                    url{
                        parameters.append("date_from", "2026-09-01")
                        parameters.append("date_to", "2026-09-30")
                    }
                }
          },
          transform = {data : BudgetSummaryResponse->
              data.toDomain()
          }
      )
    
    
    override suspend fun getBudgets(url: String): NetworkResult<BudgetsModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                }
            },
            transform = { data : BudgetsResponse ->
                data.toDomain()
            }
        )
}