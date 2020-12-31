package com.jay.issues.ui

import android.os.Bundle
import com.jay.issues.R
import com.jay.issues.base.BaseActivity
import com.jay.issues.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private val issueAdapter: IssueAdapter by lazy {
        IssueAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
        viewModel.getGithubIssues()
    }

    private fun setupUi() {
        binding.rvIssueList.adapter = issueAdapter
    }

    private fun setupObserve() {
        viewModel.githubIssues.observe(this) {
            issueAdapter.setGithubIssues(it)
        }
    }

}