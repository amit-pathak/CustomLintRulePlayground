package com.ap.lintrule.issues

import com.android.tools.lint.detector.api.*
import com.ap.lintrule.mentionSanity.ColorCodeDetector

object LayoutColorCodeIssue {

    val REGEX_HEX_COLOR = "#[a-fA-F\\d]{3,8}".toRegex()

    val issue = Issue.create(
        id = ColorCodeDetector::class.java.simpleName,
        briefDescription = "Hardcoded colors in layout file in prohibited",
        explanation = "Please declare colors in '<color>' resource file",
        category = Category.CORRECTNESS,
        severity = Severity.ERROR,
        implementation = Implementation(
            ColorCodeDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}