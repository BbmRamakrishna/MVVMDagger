package com.example.mvvmarchitecture.ui.main

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.base.MainArguments
import com.example.mvvmarchitecture.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Named

@Module
internal abstract class MainModule {

    @Binds
    abstract fun bindActivity(activity: MainActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(loginViewModel: MainViewModel): ViewModel

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Named("arguments")
        fun provideArguments(activity: Activity): MainArguments {
            val data = activity.intent.getSerializableExtra("arguments")
            return data as MainArguments
        }

    }

}