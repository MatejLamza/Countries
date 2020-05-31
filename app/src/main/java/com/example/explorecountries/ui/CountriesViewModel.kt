package com.example.explorecountries.ui

import androidx.lifecycle.*
import com.example.explorecountries.common.state.Resource
import com.example.explorecountries.common.state.launch
import com.example.explorecountries.data.models.Region
import com.example.explorecountries.data.repositories.DataRepoImpl
import kotlinx.coroutines.launch

class CountriesViewModel(private val repo: DataRepoImpl) : ViewModel() {

    private val _countriesFromRegion = MutableLiveData<Resource<List<Region.RegionCountry>>>()
    val countriesFromRegion: LiveData<Resource<List<Region.RegionCountry>>> = _countriesFromRegion.distinctUntilChanged()

    init {
        launch(_countriesFromRegion) {
            _countriesFromRegion.postValue(Resource.Success(data = repo.fetchCountriesByRegion("Europe")))
        }
    }

}