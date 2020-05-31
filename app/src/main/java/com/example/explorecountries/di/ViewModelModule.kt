package com.example.explorecountries.di

import com.example.explorecountries.ui.CountriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CountriesViewModel(repo = get()) }
}