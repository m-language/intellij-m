package io.github.m.intellij.lang.editor

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import io.github.m.intellij.lang.psi.{MApplyBraceList, MApplyBracketList, MApplyParenList, MBraceList, MBracketList, MIlist, MParenList}

class MAnnotator extends Annotator with DumbAware {
  override def annotate(element: PsiElement, holder: AnnotationHolder): Unit = element match {
    case expr: MIlist =>
      if ((expr.getExprList.size() + expr.getSlistList.size()) > 1) {
        val fn = expr.getExprList.get(0)
        if (fn.getAtom != null) {
          holder.createInfoAnnotation(fn, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MParenList =>
      if (!expr.getExprList.isEmpty) {
        val fn = expr.getExprList.get(0)
        if (fn.getAtom != null) {
          holder.createInfoAnnotation(fn, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MBraceList =>
      for (x <- 0 until expr.getExprList.size()) {
        val fn = expr.getExprList.get(x)
        if (x % 2 == 1 && fn.getAtom != null) {
          holder.createInfoAnnotation(fn, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MApplyParenList =>
      holder.createInfoAnnotation(expr.getAtom, null).setTextAttributes(MSyntaxHighlighter.FUNCTION_KEY)
    case expr: MApplyBraceList =>
      holder.createInfoAnnotation(expr.getAtom, null).setTextAttributes(MSyntaxHighlighter.FUNCTION_KEY)
      for (x <- 0 until expr.getExprList.size()) {
        val fn = expr.getExprList.get(x)
        if (x % 2 == 1 && fn.getAtom != null) {
          holder.createInfoAnnotation(fn, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MApplyBracketList =>
      holder.createInfoAnnotation(expr.getAtom, null).setTextAttributes(MSyntaxHighlighter.FUNCTION_KEY)
    case _ =>
  }
}
