package com.jay.issues.ui.detail

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

}