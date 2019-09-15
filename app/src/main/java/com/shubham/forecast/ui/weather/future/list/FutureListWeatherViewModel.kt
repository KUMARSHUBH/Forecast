package com.shubham.forecast.ui.weather.future.list

import com.shubham.forecast.data.provider.UnitProvider
import com.shubham.forecast.data.repository.ForecastRepository
import com.shubham.forecast.internal.lazyDeferred
import com.shubham.forecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {

        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
