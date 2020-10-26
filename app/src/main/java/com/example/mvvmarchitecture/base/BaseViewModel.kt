package com.example.mvvmarchitecture.base

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.repository.ILocalDataRepository
import com.google.android.gms.location.FusedLocationProviderClient
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    lateinit var navigatorListener: Navigator
    val systemAlertListener = ObservableField(ErrorTemplate.NONE)
    val loadingListener = ObservableField(ErrorTemplate.NONE)
    lateinit var fusedLocationClient: FusedLocationProviderClient

    @Inject
    internal lateinit var localDataRepository: ILocalDataRepository

    fun route(navigateTo: String, data: Any? = null) {
        this.navigatorListener.navigate(navigateTo, data)
    }

    protected fun handleError(throwable: Throwable?, callback: (message: String?) -> Unit) {
        var message = when (throwable) {
            is HttpException -> {
                throwable.message()
            }
            is SocketTimeoutException -> {
                throwable.localizedMessage
            }
            is UnknownHostException -> {
                systemAlertListener.set(ErrorTemplate.NO_INTERNET)
                null
            }
            else -> {
                "Unknown"
            }
        }
        if (!message.isNullOrEmpty()) {
            callback(message)
        }
        Log.d(this.javaClass.canonicalName, "Error=$message")
    }

    fun showDefaultLoader() {
        systemAlertListener.set(ErrorTemplate.DEFAULT_LOADER_SHOW)
    }

    fun dismissDefaultLoader() {
        systemAlertListener.set(ErrorTemplate.DEFAULT_LOADER_DISMISS)
    }

}