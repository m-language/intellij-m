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
    """## The natural number 0.
      |def 0
      |  fn f x x
      |
      |## Tests if a natural number is 0.
      |defn 0?(n)
      |  n(const(true), false)
      |
      |## The successor of a natural number.
      |defn inc(n, f, x)
      |  f(n(f, x))
      |
      |## The predecessor of a natural number.
      |defn dec(n, f, x)
      |  n(fn g h h(g(f)), const(x), id)
      |
      |## Adds two natural numbers.
      |defnrec {a + b}
      |  if 0?(b)
      |    a
      |    {inc(a) + dec(b)}
      |
      |## Subtracts two natural numbers.
      |defnrec {a - b}
      |  if 0?(b)
      |    a
      |    {dec(a) - dec(b)}
      |
      |## True if the first natural number is less than the second natural number.
      |defnrec {a < b}
      |  cond
      |    0?(a)
      |      not(0?(b))
      |    0?(b)
      |      false
      |    {dec(a) < dec(b)}
      |
      |## True if the first natural number is greater than the second natural number.
      |def > swap(<)
      |"""
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
    new AttributesDescriptor("Parentheses", MSyntaxHighlighter.PAREN_KEY),
    new AttributesDescriptor("Braces", MSyntaxHighlighter.BRACE_KEY),
    new AttributesDescriptor("Brackets", MSyntaxHighlighter.BRACKET_KEY),
    new AttributesDescriptor("Identifiers", MSyntaxHighlighter.IDENTIFIER_KEY),
    new AttributesDescriptor("Strings", MSyntaxHighlighter.STRING_KEY),
    new AttributesDescriptor("Numbers", MSyntaxHighlighter.NUMBER_KEY),
    new AttributesDescriptor("Keywords", MSyntaxHighlighter.KEYWORD_KEY),
    new AttributesDescriptor("Functions", MSyntaxHighlighter.FUNCTION_KEY)
  )
}
