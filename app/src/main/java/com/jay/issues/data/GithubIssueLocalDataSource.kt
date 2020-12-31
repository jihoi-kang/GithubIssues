package com.jay.issues.data

import com.jay.issues.model.GithubIssue

interface GithubIssueLocalDataSource {

    fun setLatestRepo(repo: String)
    fun getLatestRepo(): String?

    fun setGithubIssues(githubIssues: List<GithubIssue>)
    fun getGithubIssue(id: Int): GithubIssue

}