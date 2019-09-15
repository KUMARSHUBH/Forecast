package com.shubham.forecast.data.network.response


import com.google.gson.annotations.SerializedName
import com.shubham.forecast.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)