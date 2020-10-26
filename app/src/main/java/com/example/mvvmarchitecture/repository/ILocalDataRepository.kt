package com.example.mvvmarchitecture.repository

import com.example.mvvmarchitecture.server.response.PagesData


interface ILocalDataRepository {
    fun getCurrentToken(): String

    fun getPagesResponse(): PagesData

    fun clearLocalStorage()

    fun setPagesResponse(pagesDateResponse: PagesData)
}