package com.jay.issues.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jay.issues.BR

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding>(
    @LayoutRes val resourceId: Int,
    private val viewModelClass: Class<VM>,
) : AppCompatActivity() {

    protected lateinit var binding: B

    protected val viewModel: VM by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resourceId)
        with(binding) {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }
    }
}