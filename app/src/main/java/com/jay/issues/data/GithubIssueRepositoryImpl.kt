package com.jay.issues.data

import com.jay.issues.model.GithubIssue
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class GithubIssueRepositoryImpl @Inject constructor(
    private val githubIssueRemoteDataSource: GithubIssueRemoteDataSource,
    private val githubIssueLocalDataSource: GithubIssueLocalDataSource,
) : GithubIssueRepository {

    override suspend fun getGithubIssues(org: String, repo: String): List<GithubIssue> =
        githubIssueRemoteDataSource.getGithubIssues(org, repo)

}

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueRepository(githubIssueRepositoryImpl: GithubIssueRepositoryImpl): GithubIssueRepository
}