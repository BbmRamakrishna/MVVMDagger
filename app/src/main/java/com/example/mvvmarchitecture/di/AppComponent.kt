package com.example.mvvmarchitecture.di

import android.app.Application
import com.example.mvvmarchitecture.base.ApplicationClass
import com.example.mvvmarchitecture.di.modules.builders.ActivityBuilder
import com.example.mvvmarchitecture.di.modules.builders.FragmentBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        AppModule::class,
        ApiModule::class,
        RepositoryModule::class,
        UiCommonModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
        fun appModule(module: AppModule): Builder

        @BindsInstance
        fun application(application: Application): Builder
    }


    fun inject(app: ApplicationClass)
}