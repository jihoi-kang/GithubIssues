package com.jay.issues.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jay.issues.R
import com.jay.issues.base.BaseActivity
import com.jay.issues.databinding.ActivityIssueDetailBinding
import com.jay.issues.model.GithubIssue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IssueDetailActivity : BaseActivity<IssueDetailViewModel, ActivityIssueDetailBinding>(
    R.layout.activity_issue_detail,
    IssueDetailViewModel::class.java,
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val githubIssue = intent.getIntExtra(EXTRA_ID, -1)
        viewModel.getGithubIssue(githubIssue)
    }

    companion object {

        private const val EXTRA_ID = "android.intent.extra.ID"

        fun getIntent(
            context: Context,
            id: Int
        ) = Intent(context, IssueDetailActivity::class.java).apply {
            putExtra(EXTRA_ID, id)
        }
    }

}