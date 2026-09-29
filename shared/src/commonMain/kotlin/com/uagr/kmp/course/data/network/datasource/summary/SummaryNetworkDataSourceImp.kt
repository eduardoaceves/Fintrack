package com.uagr.kmp.course.data.network.datasource.summary

import com.uagr.kmp.course.data.network.model.response.summary.SummaryResponse
import com.uagr.kmp.course.domain.mapper.summary.toDomain
import com.uagr.kmp.course.domain.model.summary.SummaryDataModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Factory

@Factory
class SummaryNetworkDataSourceImp(
    private val httpClient: HttpClient
) : SummaryNetworkDataSource {
    
    override suspend fun getSummary(
        accountId : String,
        url: String
    ): NetworkResult<SummaryDataModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(url){
                    contentType(type = ContentType.Application.Json)
                    url {
                        //parameters.append("date_from", "2026-08-01")
                        //rameters.append("date_to", "2026-09-30")
                        parameters.append("accountId", accountId)
                    }
                }
                /*httpClient.get(urlString = url){
                    contentType(type = ContentType.Application.Json)
                }*/
            },
            transform = { data : SummaryResponse ->
                data.toDomain()
            }
        )
    
}