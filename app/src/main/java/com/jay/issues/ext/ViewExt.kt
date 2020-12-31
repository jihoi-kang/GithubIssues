package com.jay.issues.ext

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["visible"])
fun View.bindVisible(visible: Boolean) {
    isVisible = visible
}