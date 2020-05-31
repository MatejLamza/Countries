package com.example.explorecountries.ui.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.example.explorecountries.data.models.Region

class MainController : TypedEpoxyController<List<Region.RegionCountry>>() {

    private var listener: ((country: Region.RegionCountry) -> Unit)? = null

    override fun buildModels(data: List<Region.RegionCountry>?) {
        data?.forEach {
            countryItemView {
                id(it.numericCode.toLong())
                countryName(it.name)
                countryCapital(it.capital)
                countryPopulation(it.population)
                onBind { _, view, _ ->
                    view.setOnClickListener { _ ->
                        listener?.invoke(it)
                    }
                }
            }
        }
    }

    fun setOnCountryClickListener(listener: (country: Region.RegionCountry) -> Unit) {
        this.listener = listener
    }
}