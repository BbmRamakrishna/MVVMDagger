package com.example.mvvmarchitecture.base

import android.view.View
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import com.example.mvvmarchitecture.R

object ViewDataBinder {

    @JvmStatic
    @BindingAdapter("slideUp")
    fun bindSlideUpAnimation(view: View, slideUp: Boolean) {
        if (slideUp) {
            view.startAnimation(AnimationUtils.loadAnimation(view.context, R.anim.slide_up))
        }else{
            view.startAnimation(AnimationUtils.loadAnimation(view.context, R.anim.slide_down))
        }
    }
}