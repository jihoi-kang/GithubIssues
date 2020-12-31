package com.jay.issues.data

interface GithubIssueLocalDataSource {

    fun setLatestRepo(repo: String)
    fun getLatestRepo(): String?
}