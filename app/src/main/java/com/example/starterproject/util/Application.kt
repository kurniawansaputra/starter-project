package com.example.starterproject.util

import android.app.Application
import com.example.starterproject.di.appModule
import com.example.starterproject.di.repositoryModule
import com.example.starterproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@Application)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}