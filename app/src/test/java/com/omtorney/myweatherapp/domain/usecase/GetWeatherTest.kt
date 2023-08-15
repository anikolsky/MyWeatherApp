package com.omtorney.myweatherapp.domain.usecase

import com.google.common.truth.Truth
import com.omtorney.myweatherapp.data.model.Condition
import com.omtorney.myweatherapp.data.model.Current
import com.omtorney.myweatherapp.data.model.Day
import com.omtorney.myweatherapp.data.model.ForecastDay
import com.omtorney.myweatherapp.data.model.ForecastDto
import com.omtorney.myweatherapp.data.model.Location
import com.omtorney.myweatherapp.data.model.WeatherResponse
import com.omtorney.myweatherapp.domain.model.Forecast
import com.omtorney.myweatherapp.domain.model.WeatherInfo
import com.omtorney.myweatherapp.domain.repository.Repository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetWeatherTest {

    @get:Rule
    val mockKRule = MockKRule(this)

    private val dispatcher = StandardTestDispatcher()

    @MockK
    private lateinit var repository: Repository
    private lateinit var getWeather: GetWeather

    private val query = "Moscow"

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        getWeather = GetWeather(repository)

        coEvery { repository.getWeather(query) } returns createMockWeatherResponse()
    }

    @After
    fun close() {
        Dispatchers.resetMain()
    }

    @Test
    fun getWeather_Assert_WeatherInfoIsRight() = runTest {
        val value = getWeather(query).last().data
        val expected = createMockWeatherInfo()

        dispatcher.scheduler.advanceUntilIdle()

        Truth.assertThat(value).isEqualTo(expected)
    }

    private fun createMockWeatherInfo(): WeatherInfo {
        return WeatherInfo(
            query,
            20.0,
            "Rain",
            "",
            listOf(
                Forecast(
                    "15.08.2023",
                    "Rain",
                    "",
                    20.0,
                    0.0,
                    0.0
                )
            )
        )
    }

    private fun createMockWeatherResponse(): WeatherResponse {
        return WeatherResponse(
            Location(query),
            Current(
                20.0,
                Condition(
                    "Rain",
                    ""
                )
            ),
            ForecastDto(
                listOf(
                    ForecastDay(
                        1692091271L,
                        Day(
                            20.0,
                            0.0,
                            0.0,
                            Condition(
                                "Rain",
                                ""
                            )
                        )
                    )
                )
            )
        )
    }
}
