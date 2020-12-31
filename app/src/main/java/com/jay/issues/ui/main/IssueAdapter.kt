package com.jay.issues.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.issues.Const
import com.jay.issues.R
import com.jay.issues.model.GithubIssue
import com.jay.issues.model.ImageItem
import com.jay.issues.model.ItemViewType

class IssueAdapter : RecyclerView.Adapter<IssueViewHolder>() {

    private val items: MutableList<Any> = mutableListOf()

    private val imageItem: ImageItem by lazy {
        ImageItem(
            Const.HELLO_BOT_IMAGE_URL,
            R.layout.item_image
        )
    }

    fun setGithubIssues(githubIssues: List<GithubIssue>) {
        this.items.clear()
        this.items.addAll(githubIssues)
        this.items.add(4, imageItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        return IssueViewHolder(layoutResId = viewType, parent = parent)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (val item = items[position]) {
            is ItemViewType -> item.itemLayoutResId
            else -> error("Only items that implement ItemViewType as interface are allowed")
        }
    }
}