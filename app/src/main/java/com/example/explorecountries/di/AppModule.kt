package com.example.explorecountries.di

import com.example.explorecountries.data.network.RESTCountriesDataSource
import com.example.explorecountries.data.network.services.APIService
import com.example.explorecountries.data.repositories.DataRepoImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://restcountries.eu/rest/v2/"

val appModule = module {

    fun provideAPIService(): APIService {
        val okHttpClient = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

//    fun provideDataRepository(countriesDataSource: RESTCountriesDataSource): DataRepo {
//        return DataRepoImpl(countriesDataSource)
//    }

    single { DataRepoImpl(dataSource = get()) }

    single { provideAPIService() }
}