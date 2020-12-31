package com.jay.issues.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class GithubIssueLocalDataSourceImpl @Inject constructor() : GithubIssueLocalDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class GithubIssueLocalDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindGithubIssueLocalDataSource(githubIssueLocalDataSourceImpl: GithubIssueLocalDataSourceImpl): GithubIssueLocalDataSource
}