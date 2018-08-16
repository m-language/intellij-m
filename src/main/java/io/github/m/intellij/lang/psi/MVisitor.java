// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MVisitor extends PsiElementVisitor {

  public void visitAtom(@NotNull MAtom o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull MExpr o) {
    visitPsiElement(o);
  }

  public void visitList(@NotNull MList o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
