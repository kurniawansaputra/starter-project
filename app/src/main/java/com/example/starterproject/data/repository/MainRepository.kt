package com.example.starterproject.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.starterproject.data.Result
import com.example.starterproject.data.source.local.LocalDataSource
import com.example.starterproject.data.source.remote.RemoteDataSource
import com.example.starterproject.data.source.remote.network.ApiConfig
import com.example.starterproject.data.source.response.UserResponse

class MainRepository(private val local: LocalDataSource, private val remote: RemoteDataSource) {
    fun getUsers(): LiveData<Result<UserResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = remote.getUsers()
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}