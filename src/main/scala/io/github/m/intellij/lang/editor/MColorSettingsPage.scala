package io.github.m.intellij.lang.editor

import java.util

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import icons.MPluginIcons
import javax.swing.Icon

class MColorSettingsPage extends ColorSettingsPage {
  override def getHighlighter: SyntaxHighlighter = new MSyntaxHighlighter()

  override def getAdditionalHighlightingTagToDescriptorMap: util.Map[String, TextAttributesKey] =
    util.Collections.singletonMap("keyword", MSyntaxHighlighter.KEYWORD_KEY)

  override def getIcon: Icon = MPluginIcons.M_ICON

  override def getDemoText: String =
    """;;; Demo text for the M IntelliJ plugin.
      |(<keyword>import</keyword> io.github.m.std.list)
      |
      |;; The quote-inline macro is identical to the quote macro except that it takes
      |;; variadic arguments instead of a list.
      |(<keyword>macro</keyword> quote-inline)
      |(<keyword>def</keyword> quote-inline
      |  (<keyword>lambda</keyword> expr
      |    (<keyword>if</keyword> (nil? expr)
      |      ()
      |      (<keyword>if</keyword> (list? (car expr))
      |        (<keyword>if</keyword> (and (keyword? (caar expr))
      |                 (<keyword>lambda</keyword> (eq-keyword (caar expr) (<keyword>keyword</keyword> unquote))))
      |          (list
      |            (<keyword>keyword</keyword> cons)
      |            (cadr (car expr))
      |            ((id quote-inline) (cdr expr)))
      |          (<keyword>if</keyword> (and (keyword? (caar expr))
      |                   (<keyword>lambda</keyword> (eq-keyword (caar expr) (<keyword>keyword</keyword> splice))))
      |            (list
      |              (<keyword>keyword</keyword> append-list)
      |              (cadr (car expr))
      |              ((id quote-inline) (cdr expr)))
      |            (list
      |              (<keyword>keyword</keyword> cons)
      |              ((id quote-inline) (car expr))
      |              ((id quote-inline) (cdr expr)))))
      |        (list
      |          (<keyword>keyword</keyword> cons)
      |          (list (<keyword>keyword</keyword> keyword) (car expr))
      |          ((id quote-inline) (cdr expr)))))))
      |
      |(quote-inline \a \b \c)        ; (a b c)
      |(quote-inline "Hello" "World") ; (Hello World)
      |(quote-inline 1 2 3)           ; (1 2 3)"""
      .stripMargin
      .replaceAll("\r\n|\r|\n", "\n")

  override def getAttributeDescriptors: Array[AttributesDescriptor] = MColorSettingsPage.attributesDescriptors

  override def getDisplayName: String = "M"

  override def getColorDescriptors: Array[ColorDescriptor] = ColorDescriptor.EMPTY_ARRAY
}

object MColorSettingsPage {
  val attributesDescriptors = Array(
    new AttributesDescriptor("Comments", MSyntaxHighlighter.COMMENT_KEY),
    new AttributesDescriptor("Doc Comments", MSyntaxHighlighter.DOC_COMMENT_KEY),
    new AttributesDescriptor("Title Comments", MSyntaxHighlighter.TITLE_COMMENT_KEY),
    new AttributesDescriptor("Keywords", MSyntaxHighlighter.KEYWORD_KEY),
    new AttributesDescriptor("Identifiers", MSyntaxHighlighter.IDENTIFIER_KEY),
    new AttributesDescriptor("Parentheses", MSyntaxHighlighter.PARENTHESES_KEY),
    new AttributesDescriptor("Strings", MSyntaxHighlighter.STRING_KEY),
    new AttributesDescriptor("Numbers", MSyntaxHighlighter.NUMBER_KEY)
  )
}
