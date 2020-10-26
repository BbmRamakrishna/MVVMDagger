package com.example.mvvmarchitecture.repository

import com.example.mvvmarchitecture.server.ForecastResponse
import com.example.mvvmarchitecture.server.WeatherResponse
import com.example.mvvmarchitecture.server.response.AssignmentResponse
import com.igweze.ebi.simplecalladapter.Simple

interface IRepository {

    fun getWeather(): Simple<WeatherResponse>

    fun getForecast(): Simple<ForecastResponse>

    fun getAssignmentResonse() : Simple<AssignmentResponse>
}