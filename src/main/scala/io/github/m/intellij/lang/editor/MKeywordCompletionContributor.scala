package io.github.m.intellij.lang.editor

import com.intellij.codeInsight.completion._
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import io.github.m.intellij.lang.MLanguage
import io.github.m.intellij.lang.lexer.MTokenTypes

class MKeywordCompletionContributor extends CompletionContributor {
  {
    extend(
      CompletionType.BASIC,
      PlatformPatterns.psiElement(MTokenTypes.IDENTIFIER).withLanguage(MLanguage.INSTANCE),
      new CompletionProvider[CompletionParameters]() {
        override def addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet): Unit = {
          result.addElement(LookupElementBuilder.create("def"))
          result.addElement(LookupElementBuilder.create("fn"))
          result.addElement(LookupElementBuilder.create("macro"))
        }
      }
    )
  }
}
