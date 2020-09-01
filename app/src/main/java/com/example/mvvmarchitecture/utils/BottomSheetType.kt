package com.example.mvvmarchitecture.utils

import android.graphics.drawable.Drawable
import android.view.View
import java.io.Serializable

data class BottomSheetType(
        val title: String? = null,
        val msg: String? = null,
        val submessage: String? = null,
        val buttonText: String? = null,
        val buttonDrawable: Drawable? = null,
        val buttonVisibility: Boolean? = true,
        val iconDrawable: Drawable? = null,
        val underLineTextVisibility: Boolean? = false,
        val buttonClickListener: View.OnClickListener? = null,
        val bottomUnderLineText: String? = null,
        val underLineClickListener: Runnable? = null,
        val cancelable: Boolean = true,
        val autoDismiss: Boolean? = true
) : Serializable