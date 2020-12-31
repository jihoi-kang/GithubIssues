package com.jay.issues.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jay.issues.base.BaseViewModel
import com.jay.issues.data.GithubIssueRepository
import com.jay.issues.model.GithubIssue
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val githubIssueRepository: GithubIssueRepository
) : BaseViewModel() {

    private val _githubIssues = MutableLiveData<List<GithubIssue>>()
    val githubIssues: LiveData<List<GithubIssue>> get() = _githubIssues

    fun getGithubIssues() {
        viewModelScope.launch {
            val items = githubIssueRepository.getGithubIssues("google", "dagger")
            _githubIssues.value = items
        }
    }

}