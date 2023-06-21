package com.example.starterproject.data.source.remote

import com.example.starterproject.data.source.remote.network.ApiService

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}