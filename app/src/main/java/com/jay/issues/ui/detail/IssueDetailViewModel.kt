package com.jay.issues.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jay.issues.base.BaseViewModel
import com.jay.issues.data.GithubIssueRepository
import com.jay.issues.model.GithubIssue
import kotlinx.coroutines.launch

class IssueDetailViewModel @ViewModelInject constructor(
    private val githubIssueRepository: GithubIssueRepository
) : BaseViewModel() {

    private val _githubIssue = MutableLiveData<GithubIssue>()
    val githubIssue: LiveData<GithubIssue> get() = _githubIssue

    fun init() {
        viewModelScope.launch {
            // todo
        }
    }

}