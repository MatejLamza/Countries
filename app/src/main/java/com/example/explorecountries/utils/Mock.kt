package com.example.explorecountries.utils

import com.example.explorecountries.data.models.Region


object Mock {

    val regionList: List<Region> by lazy {
        listOf(
            Region("Africa", "temp"),
            Region("America", "temp"),
            Region("Asia", "temp"),
            Region("Europe", "temp"),
            Region("Oceania", "temp")
        )
    }


}