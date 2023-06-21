package com.example.starterproject.data.source.remote.network

import com.example.starterproject.data.source.response.UserResponse
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(
    ): UserResponse
}