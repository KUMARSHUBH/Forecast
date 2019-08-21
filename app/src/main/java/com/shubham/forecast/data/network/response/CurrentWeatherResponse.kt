package com.shubham.forecast.data.network.response

import com.google.gson.annotations.SerializedName
import com.shubham.forecast.data.db.entity.CurrentWeatherEntry
import com.shubham.forecast.data.db.entity.Location


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)