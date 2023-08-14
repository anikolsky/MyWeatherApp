package com.omtorney.myweatherapp.domain.repository

import com.omtorney.myweatherapp.data.model.WeatherResponse
import com.omtorney.myweatherapp.domain.model.WeatherInfo
import com.omtorney.myweatherapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getWeather(query: String): WeatherResponse
}
