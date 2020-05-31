package com.example.explorecountries.common

interface View {
    fun showLoading()
    fun dismissLoading()
    fun showError(error: Throwable)
}