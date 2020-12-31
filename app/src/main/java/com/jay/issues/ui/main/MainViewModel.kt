package com.jay.issues.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jay.issues.Const
import com.jay.issues.base.BaseViewModel
import com.jay.issues.data.GithubIssueRepository
import com.jay.issues.model.GithubIssue
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel @ViewModelInject constructor(
    private val githubIssueRepository: GithubIssueRepository
) : BaseViewModel() {

    private val _repo = MutableLiveData<String>()
    val repo: LiveData<String> get() = _repo

    private var cachedRepo: String = Const.DEFAULT_REPO

    val githubIssues: LiveData<List<GithubIssue>>
        get() = _repo.switchMap { repo ->
            liveData {
                try {
                    showLoading()
                    val items = githubIssueRepository.getGithubIssues(Const.DEFAULT_ORG, repo)
                    cachedRepo = repo
                    hideLoading()
                    emit(items)
                } catch (e: HttpException) {
                    hideLoading()
                    e.printStackTrace()
                    _errorPopupEvent.value = e.code()
                    _repo.value = cachedRepo
                }
            }
        }

    private val _inputPopupEvent = MutableLiveData<Unit>()
    val inputPopupEvent: LiveData<Unit> get() = _inputPopupEvent

    private val _errorPopupEvent = MutableLiveData<Int>()
    val errorPopupEvent: LiveData<Int> get() = _errorPopupEvent

    fun init() {
        viewModelScope.launch {
            getGithubIssues(githubIssueRepository.getLatestRepo() ?: Const.DEFAULT_REPO)
        }
    }

    fun getGithubIssues(repo: String) {
        _repo.value = repo
    }

    fun openInputPopup() {
        _inputPopupEvent.value = Unit
    }

}