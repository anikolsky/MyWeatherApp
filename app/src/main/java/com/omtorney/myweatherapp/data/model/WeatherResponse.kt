package com.omtorney.myweatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
class WeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: ForecastDto
)
