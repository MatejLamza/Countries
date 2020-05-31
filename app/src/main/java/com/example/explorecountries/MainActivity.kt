package com.example.explorecountries

import android.os.Bundle
import android.util.Log
import com.example.explorecountries.common.state.observe
import com.example.explorecountries.base.BaseActivity
import com.example.explorecountries.ui.CountriesViewModel
import com.example.explorecountries.ui.epoxy.HomeController
import com.example.explorecountries.ui.epoxy.MainController
import com.example.explorecountries.utils.Mock
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val vm: CountriesViewModel by viewModel()
    private val mainController : MainController by lazy {
        MainController()
    }

    private val controller:HomeController by lazy {
        HomeController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        epoxyList.setController(mainController)
        controller.regionList = Mock.regionList
    }

    private fun bind() {
        vm.countriesFromRegion.observe(this, this) {
            controller.countries = it
        }
    }
}
