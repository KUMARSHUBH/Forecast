package com.shubham.forecast.data.db.entity


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather_location")
data class WeatherLocation(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id")
    val tzId: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Long
)