package com.shubham.forecast.data.repository

import androidx.lifecycle.LiveData
import com.shubham.forecast.data.db.entity.WeatherLocation
import com.shubham.forecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean) : LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}
