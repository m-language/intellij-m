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
    """#(An implementation of booleans as two argument functions which ignore one
      |  argument, where (true x y) = (x) and (false x y) = (y))
      |(defmodule bool [true false not and or] {
      |  #(The singleton truthy value, a function which ignores its second argument)
      |  (defn (true x y) x)
      |
      |  #(The singleton falsy value, a function which ignores its first argument)
      |  (defn (false x y) y)
      |
      |  #(True if its argument is false)
      |  (defn (not x)
      |    (x false true))
      |
      |  #(True if both arguments are true)
      |  (defn (and x y)
      |    (x y false))
      |
      |  #(True if either argument is true)
      |  (defn (or x y)
      |    (x true y))
      |})
      |"""
      .stripMargin
      .replaceAll("\r\n|\r|\n", "\n")

  override def getAttributeDescriptors: Array[AttributesDescriptor] = MColorSettingsPage.attributesDescriptors

  override def getDisplayName: String = "M"

  override def getColorDescriptors: Array[ColorDescriptor] = ColorDescriptor.EMPTY_ARRAY
}

object MColorSettingsPage {
  val attributesDescriptors: Array[AttributesDescriptor] = Array(
    new AttributesDescriptor("Comments", MSyntaxHighlighter.COMMENT_KEY),
    new AttributesDescriptor("Parentheses", MSyntaxHighlighter.PAREN_KEY),
    new AttributesDescriptor("Braces", MSyntaxHighlighter.BRACE_KEY),
    new AttributesDescriptor("Brackets", MSyntaxHighlighter.BRACKET_KEY),
    new AttributesDescriptor("Identifiers", MSyntaxHighlighter.IDENTIFIER_KEY),
    new AttributesDescriptor("Operators", MSyntaxHighlighter.OPERATOR_KEY),
    new AttributesDescriptor("Strings", MSyntaxHighlighter.STRING_KEY),
    new AttributesDescriptor("Numbers", MSyntaxHighlighter.NUMBER_KEY),
    new AttributesDescriptor("Keywords", MSyntaxHighlighter.KEYWORD_KEY),
    new AttributesDescriptor("Functions", MSyntaxHighlighter.FUNCTION_KEY)
  )
}
