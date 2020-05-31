package com.example.explorecountries.data.models

import com.google.gson.annotations.SerializedName

data class Region(
    val regionName: String,
    val image: String
//    val listOfCountries: List<RegionCountry>
) {
    data class RegionCountry(
        val area: Double,
        val capital: String,
        val flag: String,
        val languages: List<Language>,
        val latlng: List<Double>,
        val name: String,
        val nativeName: String,
        val numericCode: String,
        val population: Int,
        val region: String,
        val subregion: String,
        val timezones: List<String>
    ) {
        data class Language(
            @SerializedName("iso639_1")
            var iso6391: String = "",
            @SerializedName("iso639_2")
            var iso6392: String = "",
            var name: String = "",
            var nativeName: String = ""
        )
    }
}