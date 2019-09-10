package io.github.m.intellij.lang.editor

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import io.github.m.intellij.lang.psi._

class MAnnotator extends Annotator with DumbAware {
  override def annotate(element: PsiElement, holder: AnnotationHolder): Unit = element match {
    case expr: MIndentExpr =>
      if ((expr.getExprList.size() + expr.getIndentExprList.size()) > 1) {
        val fn = expr.getExprList.get(0)
        if (fn.getApplyArgsList.isEmpty && fn.getAtomicExpr.getAtom != null) {
          holder.createInfoAnnotation(fn.getAtomicExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MExpr =>
      if (!expr.getApplyArgsList.isEmpty) {
        if (expr.getAtomicExpr.getAtom != null) {
          holder.createInfoAnnotation(expr.getAtomicExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.FUNCTION_KEY)
        }
      }
    case expr: MParenArgs =>
      if (expr.getExprList.size() > 1) {
        val fn = expr.getExprList.get(0)
        if (fn.getApplyArgsList.isEmpty && fn.getAtomicExpr.getAtom != null) {
          holder.createInfoAnnotation(fn.getAtomicExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MBraceArgs =>
      for (x <- 0 until expr.getExprList.size()) {
        val fn = expr.getExprList.get(x)
        if (x % 2 == 1 && fn.getAtomicExpr.getAtom != null) {
          holder.createInfoAnnotation(fn.getAtomicExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.FUNCTION_KEY)
        }
      }
    case expr: MBracketExpr =>
      holder.createInfoAnnotation(expr, null).setTextAttributes(MSyntaxHighlighter.TEMPLATE_KEY)
    case expr: MApplyBracketArgs =>
      holder.createInfoAnnotation(expr, null).setTextAttributes(MSyntaxHighlighter.TEMPLATE_KEY)
    case _ =>
  }
}
