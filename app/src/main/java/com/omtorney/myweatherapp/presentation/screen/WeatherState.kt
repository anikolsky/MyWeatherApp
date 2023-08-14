package com.omtorney.myweatherapp.presentation.screen

import com.omtorney.myweatherapp.domain.model.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo = WeatherInfo("", 0.0, "", "", emptyList()),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
