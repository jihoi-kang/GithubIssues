package com.jay.issues.api

import com.jay.issues.model.GithubIssue
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubIssueService {

    @GET("/repos/{org}/{repo}/issues")
    suspend fun getGithubIssues(
        @Path("org") org: String,
        @Path("repo") repo: String,
    ): List<GithubIssue>

}