package com.shubham.forecast.ui.weather.future.detail

import com.shubham.forecast.data.provider.UnitProvider
import com.shubham.forecast.data.repository.ForecastRepository
import com.shubham.forecast.internal.lazyDeferred
import com.shubham.forecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}