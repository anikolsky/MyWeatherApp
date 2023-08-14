package com.omtorney.myweatherapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.omtorney.myweatherapp.domain.model.Forecast

@Composable
fun ForecastCard(
    forecast: Forecast
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp)
    ) {
        Text(
            text = forecast.date,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = "${forecast.avgTempC} °C",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = forecast.conditionText,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = "Wind speed ${forecast.maxWindKph}",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = "Humidity ${forecast.avgHumidity}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data("http:${forecast.conditionIcon}")
                    .crossfade(300)
                    .scale(Scale.FILL)
                    .build(),
                contentDescription = "Condition",
                modifier = Modifier
                    .height(30.dp)
                    .height(30.dp)
            )
        }
        Divider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f))
    }
}
