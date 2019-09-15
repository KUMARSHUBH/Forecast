package com.shubham.forecast.ui.weather.current

import com.shubham.forecast.data.provider.UnitProvider
import com.shubham.forecast.data.repository.ForecastRepository
import com.shubham.forecast.internal.lazyDeferred
import com.shubham.forecast.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider)
    : WeatherViewModel(forecastRepository,unitProvider) {

    private  val unitSystem = unitProvider.getUnitSystem()

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }

    }

