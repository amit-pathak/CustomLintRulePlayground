package com.ap.lintrule.mentionSanity

import com.android.tools.lint.detector.api.*
import com.ap.lintrule.issues.LoggerIssue
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class AndroidLogDetector : Detector(), SourceCodeScanner {

    override fun getApplicableMethodNames(): List<String> {
        return listOf("v", "d", "i", "w", "e")
    }

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        super.visitMethodCall(context, node, method)
        val evaluator = context.evaluator
        if (evaluator.isMemberInClass(method, LoggerIssue.PACKAGE_NAME)) {
            reportUsage(context, node)
        }
    }


    private fun reportUsage(context: JavaContext, node: UCallExpression) {
        context.report(
            issue = LoggerIssue.issue,
            scope = node,
            location = context.getCallLocation(
                call = node,
                includeReceiver = true,
                includeArguments = true
            ),
            message = ""
        )
    }

}