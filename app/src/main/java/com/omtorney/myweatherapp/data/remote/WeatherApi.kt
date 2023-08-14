package com.omtorney.myweatherapp.data.remote

import com.omtorney.myweatherapp.BuildConfig
import com.omtorney.myweatherapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/forecast.json")
    suspend fun fetchWeather(
        @Query("q") query: String,
        @Query("days") days: Int = 5,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ) : WeatherResponse
}
