package com.example.mvvmarchitecture.di

import android.content.Context
import com.example.mvvmarchitecture.base.ApplicationClass
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: ApplicationClass) {

    @Singleton
    @Provides
    fun provideApp(): ApplicationClass = context

    @Singleton
    @Provides
    fun provideContext(): Context = context

}