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

    @Query("SELECT * FROM GithubIssue WHERE id = :id_")
    fun getGithubIssue(id_: Int): GithubIssue

    @Query("DELETE FROM GithubIssue")
    fun clearGithubIssues()

}