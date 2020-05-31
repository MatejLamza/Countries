package com.example.explorecountries.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

class ExploreCountriesDI(private val application: Application) {

    private lateinit var koinApplication: KoinApplication
    private val modules:List<Module> = listOf(
        appModule,
        dataSourceModule,
        viewModelModule
    )

    fun initialize(){
        koinApplication = startKoin {
            androidLogger(Level.INFO)
            androidContext(application)
            modules(modules)
        }
    }
}