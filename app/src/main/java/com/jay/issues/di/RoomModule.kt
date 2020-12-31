package com.jay.issues.di

import android.content.Context
import androidx.room.Room
import com.jay.issues.room.AppDatabase
import com.jay.issues.room.GithubIssueDao
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Provides
    @Reusable
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "GithubIssue.db",
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Reusable
    fun provideGithubIssueDao(appDatabase: AppDatabase): GithubIssueDao =
        appDatabase.githubIssueDao()

}