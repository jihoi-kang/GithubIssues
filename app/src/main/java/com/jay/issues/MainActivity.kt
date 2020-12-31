package com.jay.issues

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jay.issues.api.GithubIssueService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var githubIssueService: GithubIssueService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val items = githubIssueService.getGithubIssues("google", "dagger")
            items.forEach {
                Log.e("TAG", "title: ${it.title}")
            }
        }
    }

}