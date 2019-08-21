package com.shubham.forecast.data.network.response

import com.google.gson.annotations.SerializedName
import com.shubham.forecast.data.db.entity.CurrentWeatherEntry
import com.shubham.forecast.data.db.entity.WeatherLocation


data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)