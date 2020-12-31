package com.jay.issues.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jay.issues.BR

class IssueViewHolder(
    private val viewModel: MainViewModel,
    @LayoutRes layoutResId: Int,
    parent: ViewGroup?,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent?.context)
        .inflate(layoutResId, parent, false)
) {

    private val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

    fun bind(item: Any) {
        binding.run {
            setVariable(BR.item, item)
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }
    }

}