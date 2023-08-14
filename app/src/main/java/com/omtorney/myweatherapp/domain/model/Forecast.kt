package com.omtorney.myweatherapp.domain.model

class Forecast(
    val date: String,
    val conditionText: String,
    val conditionIcon: String,
    val avgTempC: Double,
    val maxWindKph: Double,
    val avgHumidity: Double
)
