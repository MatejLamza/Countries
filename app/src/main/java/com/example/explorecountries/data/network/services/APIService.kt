package com.example.explorecountries.data.network.services

import com.example.explorecountries.data.models.Region
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("region/{region}")
    fun fetchCountriesForRegion(@Path("region")region:String):Deferred<List<Region.RegionCountry>>
}