package com.jay.issues.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jay.issues.model.GithubIssue

@Dao
interface GithubIssueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGithubIssues(githubIssues: List<GithubIssue>)

    @Query("SELECT * FROM GithubIssue WHERE number = :number_")
    fun getGithubIssue(number_: Int): GithubIssue?

    @Query("SELECT * FROM GithubIssue WHERE repo = :repo_")
    fun getGithubIssues(repo_: String): List<GithubIssue>?

    @Query("DELETE FROM GithubIssue")
    fun clearGithubIssues()

}