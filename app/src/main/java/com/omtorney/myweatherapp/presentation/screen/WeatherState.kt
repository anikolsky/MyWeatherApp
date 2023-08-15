package com.omtorney.myweatherapp.presentation.screen

import com.omtorney.myweatherapp.domain.model.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
