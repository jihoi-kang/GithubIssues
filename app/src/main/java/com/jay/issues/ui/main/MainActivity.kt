package com.jay.issues.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.jay.issues.Const
import com.jay.issues.R
import com.jay.issues.base.BaseActivity
import com.jay.issues.databinding.ActivityMainBinding
import com.jay.issues.ui.detail.IssueDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private val issueAdapter: IssueAdapter by lazy {
        IssueAdapter(viewModel)
    }

    private val dialog: AlertDialog by lazy {
        AlertDialog.Builder(this)
            .setView(inputEditText)
            .setPositiveButton(getString(R.string.text_okay)) { dialog, _ ->
                dialog.dismiss()
                viewModel.getGithubIssues(inputEditText.text.toString())
            }.setNegativeButton(getString(R.string.text_cancel)) { dialog, _ ->
                dialog.dismiss()
            }.create()
    }

    private val inputEditText: EditText by lazy {
        EditText(this).apply {
            hint = getString(R.string.msg_enter_repository)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
        viewModel.init()
    }

    private fun setupUi() {
        binding.rvIssueList.adapter = issueAdapter
    }

    private fun setupObserve() {
        viewModel.githubIssues.observe(this) { items ->
            items.forEach { it.itemLayoutResId = R.layout.item_github_issue }
            issueAdapter.setGithubIssues(items)
        }
        viewModel.inputPopupEvent.observe(this) {
            inputEditText.setText("")
            dialog.show()
        }
        viewModel.errorPopupEvent.observe(this) { code ->
            val message =
                if (code == Const.HTTP_NOT_FOUND) getString(R.string.msg_no_search_results_found)
                else getString(R.string.msg_unknown_error_occurred)
            AlertDialog.Builder(this)
                .setTitle(message)
                .setPositiveButton(getString(R.string.text_okay)) { dialog, _ ->
                    dialog.dismiss()
                }.show()
        }
        viewModel.openIssueDetailEvent.observe(this) { id ->
            startActivity(IssueDetailActivity.getIntent(this@MainActivity, id))
        }
        viewModel.openWebEvent.observe(this) { url ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

}