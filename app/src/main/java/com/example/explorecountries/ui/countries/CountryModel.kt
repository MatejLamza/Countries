package com.example.explorecountries.ui.countries

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.explorecountries.R
import com.example.explorecountries.data.models.Region
import kotlinx.android.synthetic.main.item_country.view.*

@EpoxyModelClass(layout = R.layout.item_country)
abstract class CountryModel : EpoxyModelWithHolder<CountryModel.Holder>() {

    @EpoxyAttribute
    lateinit var country: Region.RegionCountry
    override fun bind(holder: Holder) {
        super.bind(holder)
        with(country) {
            holder.countryName.text = country.name
            holder.countryPopulation.text = country.population.toString()
            holder.countryCapital.text = country.capital
        }
    }

    inner class Holder : EpoxyHolder() {
        lateinit var countryFlag: ImageView
        lateinit var countryName: TextView
        lateinit var countryCapital: TextView
        lateinit var countryPopulation: TextView

        override fun bindView(itemView: View) {
            countryFlag = itemView.countryFlagImageView
            countryName = itemView.countryNameTextView
            countryCapital = itemView.countryCapitalTextView
            countryPopulation = itemView.countryPopulationTextView
        }

    }
}