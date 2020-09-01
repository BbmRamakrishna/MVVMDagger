package com.example.mvvmarchitecture.ui.main

import androidx.databinding.ObservableBoolean

sealed class MainStateModel(open var isFormValid: ObservableBoolean = ObservableBoolean(false)) {
    data class InputModel(
        override var isFormValid: ObservableBoolean = ObservableBoolean(false)


    ) : MainStateModel()
}