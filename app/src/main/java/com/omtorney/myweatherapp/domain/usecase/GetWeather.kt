package com.omtorney.myweatherapp.domain.usecase

import com.omtorney.myweatherapp.domain.mapper.toWeatherInfo
import com.omtorney.myweatherapp.domain.model.WeatherInfo
import com.omtorney.myweatherapp.domain.repository.Repository
import com.omtorney.myweatherapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWeather @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(query: String): Flow<Resource<WeatherInfo>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getWeather(query = query).toWeatherInfo()
            emit(Resource.Success(data = result))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage!!))
        }
    }
}
