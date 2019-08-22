package com.shubham.forecast.data.provider

import com.shubham.forecast.data.db.entity.WeatherLocation

interface LocationProvider {
    suspend fun hasLocationChange(lastWeatherLocation: WeatherLocation): Boolean
    suspend fun getPreferredLocationString(): String
}