package com.jay.issues.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jay.issues.model.GithubIssue
import com.jay.issues.model.User
import com.jay.issues.room.converter.UserConverter

@Database(
    entities = [GithubIssue::class, User::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        UserConverter::class,
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun githubIssueDao(): GithubIssueDao

}