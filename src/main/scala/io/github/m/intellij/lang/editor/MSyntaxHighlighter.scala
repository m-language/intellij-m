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
    case IDENTIFIER => Array(IDENTIFIER_KEY)
    case OPEN_PAREN | CLOSE_PAREN => Array(PARENTHESES_KEY)
    case STRING | CHAR => Array(STRING_KEY)
    case NUMBER => Array(NUMBER_KEY)
    case _ => Array.empty
  }

  override def getHighlightingLexer: Lexer = new MLexerAdapter()
}

object MSyntaxHighlighter {
  val COMMENT_KEY: TextAttributesKey = createKey("M_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  val DOC_COMMENT_KEY: TextAttributesKey = createKey("M_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT)
  val IDENTIFIER_KEY: TextAttributesKey = createKey("M_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
  val PARENTHESES_KEY: TextAttributesKey = createKey("M_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
  val STRING_KEY: TextAttributesKey = createKey("M_STRING", DefaultLanguageHighlighterColors.STRING)
  val NUMBER_KEY: TextAttributesKey = createKey("M_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
  val KEYWORD_KEY: TextAttributesKey = createKey("M_KEYWROD", DefaultLanguageHighlighterColors.KEYWORD)

  def createKey(string: String, key: TextAttributesKey): TextAttributesKey =
    TextAttributesKey.createTextAttributesKey(string, key)
}
