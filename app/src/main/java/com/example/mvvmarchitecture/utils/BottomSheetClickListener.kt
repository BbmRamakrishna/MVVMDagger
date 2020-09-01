package com.example.mvvmarchitecture.utils

import androidx.databinding.ObservableBoolean

interface BottomSheetClickListener {
    fun bottomSheetClick(value: String)
    var progressVisibility : ObservableBoolean?
    var dismissSheet : ObservableBoolean?
}