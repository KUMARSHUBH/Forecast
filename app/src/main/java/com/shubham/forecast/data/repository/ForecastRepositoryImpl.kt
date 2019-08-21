package com.shubham.forecast.data.repository

import androidx.lifecycle.LiveData
import com.shubham.forecast.data.db.CurrentWeatherDao
import com.shubham.forecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import com.shubham.forecast.data.network.WeatherNetworkDataSource
import com.shubham.forecast.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import java.util.*

class ForecastRepositoryImpl(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource
)
    : ForecastRepository {

    init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever { newCurrentWeather ->
            //Persist
            persistFetchedCurrentWeather(newCurrentWeather)
        }
    }
    override suspend fun getCurrentWeatherEntry(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry> {
       return withContext(Dispatchers.IO){
           initWeatherData()
           return@withContext if (metric) currentWeatherDao.getWeatherMetric()
           else currentWeatherDao.getWeatherImperial()
       }
    }

    private suspend fun initWeatherData() {
        if(isFetchCurrentTimeNedded(ZonedDateTime.now().minusHours(1)))
            fetchCurrentWeather()
    }

    private fun persistFetchedCurrentWeather(fetchedCurrentWeather: CurrentWeatherResponse){
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherDao.upsert(fetchedCurrentWeather.currentWeatherEntry)
        }
    }

    private suspend fun fetchCurrentWeather(){
        weatherNetworkDataSource.fetchCurrentWeather(
            "Los Angeles",
            Locale.getDefault().language
        )
    }

    private fun isFetchCurrentTimeNedded(lastFetchTime: ZonedDateTime):Boolean{
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }
}