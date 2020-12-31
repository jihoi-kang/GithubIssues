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

    private val _item = MutableLiveData<GithubIssue>()
    val item: LiveData<GithubIssue> get() = _item

    fun getGithubIssue(id: Int) {
        viewModelScope.launch {
            val item = githubIssueRepository.getGithubIssue(id)
            _item.value = item
        }
    }

}