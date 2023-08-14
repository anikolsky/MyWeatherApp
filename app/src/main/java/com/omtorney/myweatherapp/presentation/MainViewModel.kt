package com.omtorney.myweatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omtorney.myweatherapp.domain.usecase.GetWeather
import com.omtorney.myweatherapp.presentation.screen.WeatherState
import com.omtorney.myweatherapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeather: GetWeather
) : ViewModel() {

    private var _weatherState = MutableStateFlow(WeatherState())
    val weatherState = _weatherState.asStateFlow()

    private val query = "Moscow"

    init {
        viewModelScope.launch {
            getWeather(query).collect { result ->
                when (result) {
                    is Resource.Loading -> _weatherState.update {
                        WeatherState(isLoading = true)
                    }

                    is Resource.Success -> _weatherState.update {
                        WeatherState(weatherInfo = result.data!!)
                    }

                    is Resource.Error -> _weatherState.update {
                        WeatherState(errorMessage = result.message!!)
                    }
                }
            }
        }
    }
}
