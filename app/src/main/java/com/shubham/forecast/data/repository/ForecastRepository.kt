package com.shubham.forecast.data.repository

import androidx.lifecycle.LiveData
import com.shubham.forecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeatherEntry(metric: Boolean) : LiveData<out UnitSpecificCurrentWeatherEntry>
}