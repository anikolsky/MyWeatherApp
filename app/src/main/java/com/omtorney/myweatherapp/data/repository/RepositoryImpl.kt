package com.omtorney.myweatherapp.data.repository

import com.omtorney.myweatherapp.data.model.WeatherResponse
import com.omtorney.myweatherapp.data.remote.WeatherApi
import com.omtorney.myweatherapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : Repository {

    override suspend fun getWeather(query: String): WeatherResponse {
        return api.fetchWeather(query)
    }
}
