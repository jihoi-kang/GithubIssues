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

    override suspend fun getGithubIssues(org: String, repo: String): List<GithubIssue> {
        val items = githubIssueRemoteDataSource.getGithubIssues(org, repo)
        githubIssueLocalDataSource.setLatestRepo(repo)
        return items
    }

    override suspend fun getLatestRepo(): String? =
        githubIssueLocalDataSource.getLatestRepo()

}

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueRepository(githubIssueRepositoryImpl: GithubIssueRepositoryImpl): GithubIssueRepository
}