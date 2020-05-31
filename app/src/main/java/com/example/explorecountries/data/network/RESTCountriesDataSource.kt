package com.example.explorecountries.data.network

import com.example.explorecountries.data.models.Region

interface RESTCountriesDataSource {
    suspend fun fetchCountriesByRegion(region:String):List<Region.RegionCountry>
}