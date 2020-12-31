package com.jay.issues.ui

import androidx.recyclerview.widget.RecyclerView
import com.jay.issues.databinding.ItemGithubIssueBinding
import com.jay.issues.model.GithubIssue

class IssueViewHolder(
    private val binding: ItemGithubIssueBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(githubIssue: GithubIssue) {
        binding.item = githubIssue
        binding.executePendingBindings()
    }

}