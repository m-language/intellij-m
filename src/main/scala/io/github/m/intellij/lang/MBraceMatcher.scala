package io.github.m.intellij.lang

import com.intellij.lang._
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import io.github.m.intellij.lang.lexer._

class MBraceMatcher extends PairedBraceMatcher {
  override def isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType): Boolean = true

  override def getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int = 0

  override def getPairs: Array[BracePair] = MBraceMatcher.pairs
}

object MBraceMatcher {
  val pairs: Array[BracePair] = Array(
    new BracePair(MTokenTypes.OPEN_PAREN, MTokenTypes.CLOSE_PAREN, false),
    new BracePair(MTokenTypes.OPEN_BRACE, MTokenTypes.CLOSE_BRACE, false),
    new BracePair(MTokenTypes.OPEN_BRACKET, MTokenTypes.CLOSE_BRACKET, false)
  )
}
