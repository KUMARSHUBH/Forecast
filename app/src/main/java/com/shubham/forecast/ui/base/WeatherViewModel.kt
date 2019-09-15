package com.shubham.forecast.ui.base

import androidx.lifecycle.ViewModel
import com.shubham.forecast.data.provider.UnitProvider
import com.shubham.forecast.data.repository.ForecastRepository
import com.shubham.forecast.internal.UnitSystem
import com.shubham.forecast.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
): ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}