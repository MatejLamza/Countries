package com.example.explorecountries.di

import com.example.explorecountries.data.network.RESTCountriesDataSource
import com.example.explorecountries.data.network.RESTCountriesDataSourceImpl
import com.example.explorecountries.data.network.services.APIService
import org.koin.dsl.module

val dataSourceModule = module {

    fun provideRestCountriesDataSource(api:APIService):RESTCountriesDataSource{
        return RESTCountriesDataSourceImpl(api)
    }

    single { provideRestCountriesDataSource(api = get()) }
}