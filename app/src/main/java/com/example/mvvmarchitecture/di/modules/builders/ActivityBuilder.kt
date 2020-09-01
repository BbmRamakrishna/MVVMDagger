package com.example.mvvmarchitecture.di.modules.builders

import com.example.mvvmarchitecture.ui.main.MainActivity
import com.example.mvvmarchitecture.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}