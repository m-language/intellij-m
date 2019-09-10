package io.github.m.intellij.lang.editor

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import io.github.m.intellij.lang.editor.MSyntaxHighlighter._
import io.github.m.intellij.lang.lexer.MTokenTypes._
import io.github.m.intellij.lang.lexer.MTokens._
import io.github.m.intellij.lang.lexer._

class MSyntaxHighlighter extends SyntaxHighlighterBase() {
  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = tokenType match {
    case COMMENT => Array(COMMENT_KEY)
    case DOC_COMMENT => Array(DOC_COMMENT_KEY)
    case TITLE_COMMENT => Array(TITLE_COMMENT_KEY)
    case BLOCK_COMMENT => Array(BLOCK_COMMENT_KEY)
    case OPEN_PAREN | CLOSE_PAREN => Array(PAREN_KEY)
    case OPEN_BRACE | CLOSE_BRACE => Array(BRACE_KEY)
    case OPEN_BRACKET | CLOSE_BRACKET => Array(BRACKET_KEY)
    case IDENTIFIER => Array(IDENTIFIER_KEY)
    case STRING => Array(STRING_KEY)
    case NUMBER => Array(NUMBER_KEY)
    case COMMA => Array(COMMA_KEY)
    case _ => Array.empty
  }

  override def getHighlightingLexer: Lexer = new MLexerAdapter()
}

object MSyntaxHighlighter {
  val COMMENT_KEY: TextAttributesKey = createKey("M_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  val DOC_COMMENT_KEY: TextAttributesKey = createKey("M_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT)
  val TITLE_COMMENT_KEY: TextAttributesKey = createKey("M_TITLE_COMMENT", DefaultLanguageHighlighterColors.CONSTANT)
  val BLOCK_COMMENT_KEY: TextAttributesKey = createKey("M_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
  val PAREN_KEY: TextAttributesKey = createKey("M_PAREN", DefaultLanguageHighlighterColors.PARENTHESES)
  val BRACE_KEY: TextAttributesKey = createKey("M_BRACE", DefaultLanguageHighlighterColors.BRACES)
  val BRACKET_KEY: TextAttributesKey = createKey("M_BRACKET", DefaultLanguageHighlighterColors.BRACKETS)
  val IDENTIFIER_KEY: TextAttributesKey = createKey("M_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
  val STRING_KEY: TextAttributesKey = createKey("M_STRING", DefaultLanguageHighlighterColors.STRING)
  val NUMBER_KEY: TextAttributesKey = createKey("M_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
  val KEYWORD_KEY: TextAttributesKey = createKey("M_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
  val FUNCTION_KEY: TextAttributesKey = createKey("M_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
  val TEMPLATE_KEY: TextAttributesKey = createKey("M_TEMPLATE", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR)
  val COMMA_KEY: TextAttributesKey = createKey("M_COMMA", DefaultLanguageHighlighterColors.COMMA)

  def createKey(string: String, key: TextAttributesKey): TextAttributesKey =
    TextAttributesKey.createTextAttributesKey(string, key)
}
