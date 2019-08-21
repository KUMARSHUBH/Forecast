package com.shubham.forecast.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.shubham.forecast.data.repository.ForecastRepository
import com.shubham.forecast.internal.UnitSystem
import com.shubham.forecast.internal.lazyDefered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository)
    : ViewModel() {

    private  val unitSystem = UnitSystem.METRIC

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDefered {
        forecastRepository.getCurrentWeatherEntry(isMetric)
    }

}
