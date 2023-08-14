package com.omtorney.myweatherapp.domain.mapper

import com.omtorney.myweatherapp.data.model.WeatherResponse
import com.omtorney.myweatherapp.domain.model.Forecast
import com.omtorney.myweatherapp.domain.model.WeatherInfo
import java.text.SimpleDateFormat
import java.util.Locale

fun WeatherResponse.toWeatherInfo(): WeatherInfo {
    val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return WeatherInfo(
        locationName = location.name,
        currentTempC = current.tempC,
        currentConditionText = current.condition.text,
        currentConditionIcon = current.condition.icon,
        forecast = forecast.forecastDay.map { forecast ->
            Forecast(
                date = formatter.format(forecast.dateEpoch * 1000),
                conditionText = forecast.day.condition.text,
                conditionIcon = forecast.day.condition.icon,
                avgTempC = forecast.day.avgTempC,
                maxWindKph = forecast.day.maxWindKph,
                avgHumidity = forecast.day.avgHumidity
            )
        }
    )
}
