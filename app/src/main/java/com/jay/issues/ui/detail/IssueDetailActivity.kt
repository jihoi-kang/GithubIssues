package com.jay.issues.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.jay.issues.R
import com.jay.issues.base.BaseActivity
import com.jay.issues.databinding.ActivityIssueDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IssueDetailActivity : BaseActivity<IssueDetailViewModel, ActivityIssueDetailBinding>(
    R.layout.activity_issue_detail,
    IssueDetailViewModel::class.java,
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val org = intent.getStringExtra(EXTRA_ORG)
        val repo = intent.getStringExtra(EXTRA_REPO)
        val number = intent.getIntExtra(EXTRA_NUMBER, -1)

        if (org == null || repo == null) {
            finish()
            return
        }

        viewModel.getGithubIssue(org, repo, number)
    }

    companion object {

        private const val EXTRA_ORG = "android.intent.extra.ORG"
        private const val EXTRA_REPO = "android.intent.extra.REPO"
        private const val EXTRA_NUMBER = "android.intent.extra.NUMBER"

        fun getIntent(
            context: Context,
            org: String,
            repo: String,
            number: Int,
        ) = Intent(context, IssueDetailActivity::class.java).apply {
            putExtra(EXTRA_ORG, org)
            putExtra(EXTRA_REPO, repo)
            putExtra(EXTRA_NUMBER, number)
        }
    }

}