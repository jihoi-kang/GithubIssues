package com.jay.issues.data

import android.content.SharedPreferences
import com.jay.issues.Const
import com.jay.issues.model.GithubIssue
import com.jay.issues.room.GithubIssueDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class GithubIssueLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val githubIssueDao: GithubIssueDao
) : GithubIssueLocalDataSource {

    override fun setLatestRepo(repo: String) {
        sharedPreferences.edit()
            .putString(Const.LATEST_REPO, repo)
            .apply()
    }

    override fun getLatestRepo(): String? =
        sharedPreferences.getString(Const.LATEST_REPO, null)

    override fun setGithubIssues(githubIssues: List<GithubIssue>) {
        githubIssueDao.insertGithubIssues(githubIssues)
    }

    override fun getGithubIssueByNumber(number: Int): GithubIssue? =
        githubIssueDao.getGithubIssue(number)

    override fun getGithubIssuesByRepo(repo: String): List<GithubIssue> =
        githubIssueDao.getGithubIssues(repo) ?: emptyList()

}

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueLocalDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueLocalDataSource(githubIssueLocalDataSourceImpl: GithubIssueLocalDataSourceImpl): GithubIssueLocalDataSource
}