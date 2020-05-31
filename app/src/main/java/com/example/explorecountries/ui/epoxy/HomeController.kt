package com.example.explorecountries.ui.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.example.explorecountries.data.models.Region
import com.example.explorecountries.ui.countries.country

class HomeController : EpoxyController() {

    var regionList: List<Region> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    var countries: List<Region.RegionCountry> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        val models = regionList.map {
            RegionEpoxyModel_()
                .id("temp")
                .region(it)
        }

        carousel {
            id("regions")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }

        countries.forEach {
            country {
                id("countryi")
                country(it)
            }
        }

    }

}