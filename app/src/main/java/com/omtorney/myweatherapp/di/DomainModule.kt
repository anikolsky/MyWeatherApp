package com.omtorney.myweatherapp.di

import com.omtorney.myweatherapp.domain.repository.Repository
import com.omtorney.myweatherapp.domain.usecase.GetWeather
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetWeather(repository: Repository): GetWeather {
        return GetWeather(repository)
    }
}
