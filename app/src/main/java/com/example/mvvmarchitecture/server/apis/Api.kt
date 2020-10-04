package com.example.mvvmarchitecture.server

import com.example.mvvmarchitecture.server.response.AssignmentResponse
import com.example.mvvmarchitecture.server.response.Replies
import com.igweze.ebi.simplecalladapter.Simple
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("weather?q=hyderabad,india&APPID=17c6df7c9c9b8a3404f39d32af2bec6e")
    fun getWeather(): Simple<WeatherResponse>

    @GET("forecast/daily?mode=json&q=hyderabad&lang=english&cnt=5&APPID=17c6df7c9c9b8a3404f39d32af2bec6e")
    fun getForecast(): Simple<ForecastResponse>

    @GET("posts")
    fun getAssignmentRes() : Simple<AssignmentResponse>
}