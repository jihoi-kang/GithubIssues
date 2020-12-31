package com.jay.issues.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.issues.R
import com.jay.issues.model.GithubIssue

class IssueAdapter : RecyclerView.Adapter<IssueViewHolder>() {

    private val githubIssues: MutableList<GithubIssue> = mutableListOf()

    fun setGithubIssues(githubIssues: List<GithubIssue>) {
        this.githubIssues.clear()
        this.githubIssues.addAll(githubIssues)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        return IssueViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_github_issue,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(githubIssues[position])
    }

    override fun getItemCount(): Int = githubIssues.size

}