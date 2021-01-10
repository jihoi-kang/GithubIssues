package com.jay.issues.data

import com.jay.issues.model.GithubIssue

interface GithubIssueRepository {

    suspend fun getGithubIssues(org: String, repo: String): List<GithubIssue>

    suspend fun getLatestRepo(): String?

    suspend fun getGithubIssue(org: String, repo: String, number: Int): GithubIssue

}