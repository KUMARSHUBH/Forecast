package com.shubham.forecast.data.provider

import com.shubham.forecast.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}