package com.jay.issues.data

import com.jay.issues.api.GithubIssueService
import com.jay.issues.model.GithubIssue
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class GithubIssueRemoteDataSourceImpl @Inject constructor(
    private val githubIssueService: GithubIssueService
) : GithubIssueRemoteDataSource {

    override suspend fun getGithubIssues(org: String, repo: String): List<GithubIssue> =
        githubIssueService.getGithubIssues(org, repo)

}

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueRemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueRemoteDataSource(githubIssueRemoteDataSourceImpl: GithubIssueRemoteDataSourceImpl): GithubIssueRemoteDataSource
}