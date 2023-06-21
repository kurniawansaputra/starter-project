package com.example.starterproject.di

import com.example.starterproject.data.source.local.LocalDataSource
import com.example.starterproject.data.source.remote.RemoteDataSource
import com.example.starterproject.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.getApiService() }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }
}