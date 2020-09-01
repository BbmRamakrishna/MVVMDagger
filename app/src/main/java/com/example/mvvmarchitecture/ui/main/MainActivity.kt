package com.example.mvvmarchitecture.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.mvvmarchitecture.base.BaseActivity
import com.example.mvvmarchitecture.base.MainArguments
import com.example.mvvmarchitecture.databinding.ActivityMainBinding
import kotlin.reflect.KClass

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val layoutId: Int = com.example.mvvmarchitecture.R.layout.activity_main

    override val viewModelClass: KClass<MainViewModel> = MainViewModel::class

    override fun navigate(navigateTo: String, arguments: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.callApi()
        viewModel.callForecastApi()
    }

    companion object {

        fun createActivity(context: Context, arguments: MainArguments): Intent {
            val i = Intent(context, MainActivity::class.java)
            i.putExtra("arguments", arguments)
            return i
        }
    }
}
