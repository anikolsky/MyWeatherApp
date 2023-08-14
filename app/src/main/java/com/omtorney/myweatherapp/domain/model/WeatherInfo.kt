package com.omtorney.myweatherapp.domain.model

class WeatherInfo(
    val locationName: String,
    val currentTempC: Double,
    val currentConditionText: String,
    val currentConditionIcon: String,
    val forecast: List<Forecast>
)
