package com.jay.issues.data

import android.content.SharedPreferences
import com.jay.issues.Const
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class GithubIssueLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : GithubIssueLocalDataSource {

    override fun setLatestRepo(repo: String) {
        sharedPreferences.edit()
            .putString(Const.LATEST_REPO, repo)
            .apply()
    }

    override fun getLatestRepo(): String? =
        sharedPreferences.getString(Const.LATEST_REPO, null)

}

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueLocalDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueLocalDataSource(githubIssueLocalDataSourceImpl: GithubIssueLocalDataSourceImpl): GithubIssueLocalDataSource
}