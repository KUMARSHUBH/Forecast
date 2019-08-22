package com.shubham.forecast.data.provider

import com.shubham.forecast.data.db.entity.WeatherLocation

class LocationProviderImpl : LocationProvider {
    override suspend fun hasLocationChange(lastWeatherLocation: WeatherLocation): Boolean {
        return true
    }

    override suspend fun getPreferredLocationString(): String {
        return "Los Angeles"
    }
}