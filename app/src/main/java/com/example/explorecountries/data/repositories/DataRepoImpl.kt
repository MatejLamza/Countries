package com.example.explorecountries.data.repositories

import com.example.explorecountries.data.models.Region
import com.example.explorecountries.data.network.RESTCountriesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataRepoImpl(private val dataSource: RESTCountriesDataSource) {

    suspend fun fetchCountriesByRegion(region: String): List<Region.RegionCountry> =
        dataSource.fetchCountriesByRegion(region)
}