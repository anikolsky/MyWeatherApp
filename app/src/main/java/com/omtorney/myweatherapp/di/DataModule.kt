package com.omtorney.myweatherapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.omtorney.myweatherapp.data.remote.WeatherApi
import com.omtorney.myweatherapp.data.repository.RepositoryImpl
import com.omtorney.myweatherapp.domain.repository.Repository
import com.omtorney.myweatherapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideWeatherApi() : WeatherApi {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: WeatherApi): Repository {
        return RepositoryImpl(api)
    }
}
