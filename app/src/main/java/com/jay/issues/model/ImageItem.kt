package com.jay.issues.model

data class ImageItem(
    val url: String,
    override var itemLayoutResId: Int
) : ItemViewType