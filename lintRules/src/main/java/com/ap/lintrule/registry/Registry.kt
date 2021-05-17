package com.ap.lintrule.registry

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.ap.lintrule.issues.LayoutColorCodeIssue
import com.ap.lintrule.issues.LoggerIssue

class Registry : IssueRegistry() {

    override val api: Int = CURRENT_API

    override val issues: List<Issue>
        get() = listOf(LoggerIssue.issue, LayoutColorCodeIssue.issue)
}
