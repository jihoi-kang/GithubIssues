package com.jay.issues.data

import com.jay.issues.model.GithubIssue

interface GithubIssueRemoteDataSource {

    suspend fun getGithubIssues(org: String, repo: String): List<GithubIssue>
    suspend fun getGithubIssue(org: String, repo: String, number: Int): GithubIssue

}