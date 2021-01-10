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
        var items = githubIssueLocalDataSource.getGithubIssuesByRepo(repo)

        if (items.isEmpty()) {
            items = githubIssueRemoteDataSource.getGithubIssues(org, repo)
            items.forEach { it.repo = repo }
            githubIssueLocalDataSource.setGithubIssues(items)
            githubIssueLocalDataSource.setLatestRepo(repo)
        }

        return items
    }

    override suspend fun getLatestRepo(): String? =
        githubIssueLocalDataSource.getLatestRepo()

    override suspend fun getGithubIssue(org: String, repo: String, number: Int): GithubIssue {
        return githubIssueLocalDataSource.getGithubIssueByNumber(number) ?: run {
            val item = githubIssueRemoteDataSource.getGithubIssue(org, repo, number)
            item.repo = repo
            githubIssueLocalDataSource.setGithubIssues(listOf(item))
            item
        }
    }

}

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueRepository(githubIssueRepositoryImpl: GithubIssueRepositoryImpl): GithubIssueRepository
}