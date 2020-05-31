package com.example.explorecountries.data.network

import com.example.explorecountries.data.models.Region
import com.example.explorecountries.data.network.services.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RESTCountriesDataSourceImpl(private val api:APIService) : RESTCountriesDataSource {

    override suspend fun fetchCountriesByRegion(region: String): List<Region.RegionCountry> {
        return withContext(Dispatchers.IO){
            return@withContext api.fetchCountriesForRegion(region).await()
        }
    }
}