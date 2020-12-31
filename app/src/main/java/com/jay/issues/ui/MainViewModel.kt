package com.jay.issues.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.jay.issues.base.BaseViewModel
import com.jay.issues.data.GithubIssueRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val githubIssueRepository: GithubIssueRepository
) : BaseViewModel() {

    fun getGithubIssues() {
        viewModelScope.launch {
            val items = githubIssueRepository.getGithubIssues("google", "dagger")
            items.forEach {
                Log.e("TAG", "title: ${it.title}")
            }
        }
    }

}