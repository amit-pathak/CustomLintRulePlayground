package com.ap.lintrule.issues

import com.android.tools.lint.detector.api.*
import com.ap.lintrule.mentionSanity.AndroidLogDetector

object LoggerIssue {

    internal const val PACKAGE_NAME = "android.util.Log"
    private val IMPLEMENTATION = Implementation(AndroidLogDetector::class.java, Scope.JAVA_FILE_SCOPE)

    val issue: Issue = Issue.create(
        id = "LoggerIssue",
        briefDescription = "Use of native Log is prohibited  ",
        explanation = "Please use Logger.kt for logging",
        category = Category.COMPLIANCE,
        priority = 10,
        severity = Severity.WARNING,
        androidSpecific = true,
        implementation = IMPLEMENTATION
    )
}