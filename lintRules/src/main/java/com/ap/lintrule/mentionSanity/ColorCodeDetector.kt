package com.ap.lintrule.mentionSanity

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.ap.lintrule.issues.LayoutColorCodeIssue
import com.ap.lintrule.issues.LayoutColorCodeIssue.REGEX_HEX_COLOR
import org.w3c.dom.Attr

class ColorCodeDetector : ResourceXmlDetector() {

    override fun getApplicableAttributes(): Collection<String>? {
        return ALL
    }

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        super.visitAttribute(context, attribute)
        if(context.resourceFolderType == ResourceFolderType.LAYOUT){
            val attributeValue = attribute.nodeValue
            print(attribute.name)
            if (attributeValue.matches(REGEX_HEX_COLOR)) {
                context.report(
                    issue = LayoutColorCodeIssue.issue,
                    scope = attribute,
                    location = context.getValueLocation(attribute),
                    message = ""
                )
            }
        }
    }

}
