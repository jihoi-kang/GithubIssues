package com.jay.issues.data

import com.jay.issues.model.GithubIssue

interface GithubIssueRemoteDataSource {

    suspend fun getGithubIssues(org: String, repo: String): List<GithubIssue>

}