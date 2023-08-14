package com.omtorney.myweatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Astro(
    @SerialName("sunrise") val sunrise: String,
    @SerialName("sunset") val sunset: String,
    @SerialName("moonrise") val moonrise: String,
    @SerialName("moonset") val moonset: String,
    @SerialName("moon_phase") val moonPhase: String,
    @SerialName("moon_illumination") val moonIllumination: String,
    @SerialName("is_moon_up") val isMoonUp: Int,
    @SerialName("is_sun_up") val isSunUp: Int
)
