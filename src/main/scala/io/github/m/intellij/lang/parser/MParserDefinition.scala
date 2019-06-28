package io.github.m.intellij.lang.parser

import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang._
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi._
import com.intellij.psi.tree._
import io.github.m.intellij.file._
import io.github.m.intellij.lang.MLanguage
import io.github.m.intellij.lang.lexer._
import io.github.m.intellij.lang.parser.MParserDefinition._

class MParserDefinition extends ParserDefinition {
  override def createLexer(project: Project): Lexer = new MLexer()
  override def createParser(project: Project): PsiParser = new MParser()

  override def getFileNodeType: IFileElementType = M_FILE

  override def createElement(node: ASTNode): PsiElement = MTokenTypes.Factory.createElement(node)

  override def createFile(viewProvider: FileViewProvider): PsiFile = MFile(viewProvider)

  override def spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements = SpaceRequirements.MAY

  override def getCommentTokens: TokenSet = COMMENTS
  override def getWhitespaceTokens: TokenSet = WHITESPACES
  override def getStringLiteralElements: TokenSet = STRINGS
}

object MParserDefinition {
  val COMMENTS: TokenSet = TokenSet.create(MTokens.COMMENT, MTokens.DOC_COMMENT, MTokens.TITLE_COMMENT)
  val WHITESPACES: TokenSet = TokenSet.create()
  val STRINGS: TokenSet = TokenSet.create(MTokenTypes.STRING)
  val M_FILE: IFileElementType = new IFileElementType(MLanguage.INSTANCE)
}
