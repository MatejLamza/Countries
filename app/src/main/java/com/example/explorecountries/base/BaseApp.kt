package com.example.explorecountries.base

import android.app.Application
import com.airbnb.epoxy.Carousel
import com.example.explorecountries.di.ExploreCountriesDI

class BaseApp : Application(){

    private val exploreCountriesDI:ExploreCountriesDI by lazy { ExploreCountriesDI(this) }

    override fun onCreate() {
        super.onCreate()
        exploreCountriesDI.initialize()
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }
}