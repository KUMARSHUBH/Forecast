package com.shubham.forecast.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val cnditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitation: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}