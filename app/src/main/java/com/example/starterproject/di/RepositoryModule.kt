package com.example.starterproject.di

import com.example.starterproject.data.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(get(), get()) }
}