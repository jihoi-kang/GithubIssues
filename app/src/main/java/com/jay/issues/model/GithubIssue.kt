package com.jay.issues.model

data class GithubIssue(
    val activeLockReason: Any,
    val assignee: Any,
    val assignees: List<Any>,
    val authorAssociation: String,
    val body: String,
    val closedAt: Any,
    val comments: Int,
    val commentsUrl: String,
    val createdAt: String,
    val eventsUrl: String,
    val htmlUrl: String,
    val id: Int,
    val labels: List<Any>,
    val labelsUrl: String,
    val locked: Boolean,
    val milestone: Any,
    val nodeId: String,
    val number: Int,
    val performedViaGithubApp: Any,
    val repositoryUrl: String,
    val state: String,
    val title: String,
    val updatedAt: String,
    val url: String,
    val user: User
)