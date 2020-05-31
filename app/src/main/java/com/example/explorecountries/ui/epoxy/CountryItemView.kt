package com.example.explorecountries.ui.epoxy

import android.content.Context
import android.view.View
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.example.explorecountries.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_country.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CountryItemView @JvmOverloads constructor(context: Context) : MaterialCardView(context) {

    init {
        View.inflate(context, R.layout.item_country,this)
    }

    @ModelProp
    fun countryName(name:String){
        countryNameTextView.text = name
    }

    @ModelProp
    fun countryCapital(capital:String){
        countryCapitalTextView.text = capital
    }

    @ModelProp
    fun countryPopulation(population:Int){
        countryPopulationTextView.text = population.toString()
    }
}