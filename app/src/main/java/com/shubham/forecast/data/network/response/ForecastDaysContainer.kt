package com.shubham.forecast.data.network.response


import com.google.gson.annotations.SerializedName
import com.shubham.forecast.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)