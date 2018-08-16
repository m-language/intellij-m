package io.github.m.intellij.lang.editor

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import io.github.m.intellij.lang.psi.MList

class MAnnotator extends Annotator with DumbAware {
  override def annotate(element: PsiElement, holder: AnnotationHolder): Unit = element match {
    case expr: MList =>
      if (!expr.getExprList.isEmpty) {
        val fn = expr.getExprList.get(0)
        if (fn.getList == null) {
          holder.createInfoAnnotation(fn, null).setTextAttributes(MSyntaxHighlighter.KEYWORD_KEY)
        }
      }
    case _ =>
  }
}
