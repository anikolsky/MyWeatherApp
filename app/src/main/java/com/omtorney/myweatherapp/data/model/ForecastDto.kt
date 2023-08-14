package com.omtorney.myweatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ForecastDto(
    @SerialName("forecastday") val forecastDay: List<ForecastDay>
)
