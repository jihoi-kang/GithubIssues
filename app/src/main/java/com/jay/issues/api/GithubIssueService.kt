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

    @GET("/repos/{org}/{repo}/issues/{num}")
    suspend fun getGithubIssue(
        @Path("org") org: String,
        @Path("repo") repo: String,
        @Path("num") num: Int,
    ): GithubIssue

}