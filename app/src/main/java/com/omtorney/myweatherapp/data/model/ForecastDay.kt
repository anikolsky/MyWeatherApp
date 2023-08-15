package com.omtorney.myweatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ForecastDay(
//    @SerialName("date") val date: String,
    @SerialName("date_epoch") val dateEpoch: Long,
    @SerialName("day") val day: Day,
//    @SerialName("astro") val astro: Astro,
//    @SerialName("hour") val hour: List<Hour>
)
