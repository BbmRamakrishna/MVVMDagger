package com.example.mvvmarchitecture.repository

import android.content.Context
import com.example.mvvmarchitecture.server.response.PagesData
import com.google.gson.Gson
import com.igweze.ebi.simplecalladapter.BuildConfig
import javax.inject.Inject

class LocalDataRepository @Inject constructor(val context: Context) : ILocalDataRepository {

    private val isPagesDataResponse = "isPagesDataResponse"

    private val prefs = context.getSharedPreferences("MVVM_localData", Context.MODE_PRIVATE)


    override fun getCurrentToken(): String {
        return ""
    }

    override fun clearLocalStorage() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

    override fun setPagesResponse(pagesDateResponse: PagesData) {
        val setpagesDatResponse = prefs.edit()
        setpagesDatResponse.putString(isPagesDataResponse, Gson().toJson(pagesDateResponse))
        setpagesDatResponse.apply()
    }

    override fun getPagesResponse(): PagesData {

        val user = prefs.getString(isPagesDataResponse, null)
        return Gson().fromJson(user, PagesData::class.java)
    }

}