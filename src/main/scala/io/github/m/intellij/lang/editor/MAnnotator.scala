package io.github.m.intellij.lang.editor

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import io.github.m.intellij.lang.psi._

class MAnnotator extends Annotator with DumbAware {
  override def annotate(element: PsiElement, holder: AnnotationHolder): Unit = element match {
    case expr: MBlockExpr =>
      if (expr.getOperationExprList.size() > 1 || !expr.getBlockExprList.isEmpty) {
        val fn = expr.getOperationExprList.get(0)
        if (fn.getApplyExpr != null &&
          fn.getApplyExpr.getArgsList.isEmpty &&
          fn.getOperationExpr == null &&
          fn.getApplyExpr.getParenExpr != null &&
          fn.getApplyExpr.getParenExpr.getAtom != null) {
          holder.createInfoAnnotation(fn.getApplyExpr.getParenExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case expr: MApplyExpr =>
      if (!expr.getArgsList.isEmpty) {
        if (expr.getParenExpr.getAtom != null) {
          holder.createInfoAnnotation(expr.getParenExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.FUNCTION_KEY)
        }
      }
    case expr: MArgs =>
      if (expr.getOperationExprList.size() > 1) {
        val fn = expr.getOperationExprList.get(0)
        if (fn.getApplyExpr != null &&
          fn.getApplyExpr.getParenExpr != null &&
          fn.getApplyExpr.getParenExpr.getAtom != null) {
          holder.createInfoAnnotation(fn.getApplyExpr.getParenExpr.getAtom, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case _ =>
  }
}
