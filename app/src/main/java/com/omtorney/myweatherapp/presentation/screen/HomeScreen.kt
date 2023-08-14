package com.omtorney.myweatherapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.omtorney.myweatherapp.presentation.components.ForecastCard

@Composable
fun HomeScreen(
    weatherState: WeatherState
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = weatherState.weatherInfo.locationName,
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${weatherState.weatherInfo.currentTempC} °C",
                style = MaterialTheme.typography.titleLarge
            )
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("http:${weatherState.weatherInfo.currentConditionIcon}")
                    .crossfade(300)
                    .scale(Scale.FILL)
                    .build(),
                contentDescription = "Current condition",
                modifier = Modifier
                    .height(50.dp)
                    .height(50.dp)
            )
        }
        Text(
            text = "Forecast",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 18.dp)
        )
        LazyColumn {
            items(weatherState.weatherInfo.forecast) { forecast ->
                ForecastCard(forecast)
            }
        }

        if (weatherState.errorMessage != null) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = weatherState.errorMessage,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        if (weatherState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
