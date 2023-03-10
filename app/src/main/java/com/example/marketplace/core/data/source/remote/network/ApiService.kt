package com.example.marketplace.core.data.source.remote.network

import com.example.marketplace.core.data.source.remote.request.LoginRequest
import com.example.marketplace.core.data.source.remote.response.LoginResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(
        @Body login : LoginRequest,
    ): Response<LoginResponse>
}