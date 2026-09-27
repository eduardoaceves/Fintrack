package com.uagr.kmp.course.domain.usecase.register

import com.uagr.kmp.course.data.network.model.request.register.RegisterRequest
import com.uagr.kmp.course.domain.model.register.RegisterDataModel
import com.uagr.kmp.course.domain.repository.register.RegisterRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class RegisterUserUseCase(
    private val registerUserRepository: RegisterRepository,
) {
    suspend fun registerUser(
        url : String,
        name : String,
        email : String,
        password : String
    ) : Flow<NetworkResult<RegisterDataModel>> =
        registerUserRepository.registerUser(
            url = url,
            registerRequest = RegisterRequest(
                name = name,
                email = email,
                password = password
            )
        )
}