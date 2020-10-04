package com.example.mvvmarchitecture.repository

import android.content.Context
import com.example.mvvmarchitecture.server.Api
import com.example.mvvmarchitecture.server.ForecastResponse
import com.example.mvvmarchitecture.server.WeatherResponse
import com.example.mvvmarchitecture.server.response.AssignmentResponse
import com.example.mvvmarchitecture.server.response.Replies
import com.igweze.ebi.simplecalladapter.Simple
import javax.inject.Inject

class Repository @Inject constructor(
    val context: Context,
    private val api: Api,
    private val localDataRepository: ILocalDataRepository
) : IRepository {

    override fun getWeather(): Simple<WeatherResponse> {
        return api.getWeather()
    }

    override fun getForecast(): Simple<ForecastResponse> {
        return api.getForecast()
    }

    override fun getAssignmentResonse(): Simple<AssignmentResponse> {
        return api.getAssignmentRes()
    }
}