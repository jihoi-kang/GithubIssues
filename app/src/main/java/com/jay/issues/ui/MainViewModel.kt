package com.jay.issues.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jay.issues.base.BaseViewModel
import com.jay.issues.data.GithubIssueRepository
import com.jay.issues.model.GithubIssue
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel @ViewModelInject constructor(
    private val githubIssueRepository: GithubIssueRepository
) : BaseViewModel() {

    private val _repo = MutableLiveData("Dagger")
    val repo: LiveData<String> get() = _repo

    private val _githubIssues = MutableLiveData<List<GithubIssue>>()
    val githubIssues: LiveData<List<GithubIssue>> get() = _githubIssues

    private val _inputPopupEvent = MutableLiveData<Unit>()
    val inputPopupEvent: LiveData<Unit> get() = _inputPopupEvent

    private val _errorPopupEvent = MutableLiveData<Int>()
    val errorPopupEvent: LiveData<Int> get() = _errorPopupEvent

    fun getGithubIssues(repo: String) {
        viewModelScope.launch {
            try {
                val items = githubIssueRepository.getGithubIssues("google", repo)
                _githubIssues.value = items
            } catch (e: HttpException) {
                e.printStackTrace()
                _errorPopupEvent.value = e.code()
            }
        }
    }

    fun openInputPopup() {
        _inputPopupEvent.value = Unit
    }

}