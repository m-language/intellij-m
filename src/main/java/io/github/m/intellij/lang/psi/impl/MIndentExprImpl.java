// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.m.intellij.lang.lexer.MTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.m.intellij.lang.psi.*;

public class MIndentExprImpl extends ASTWrapperPsiElement implements MIndentExpr {

  public MIndentExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MVisitor visitor) {
    visitor.visitIndentExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MVisitor) accept((MVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MExpr.class);
  }

  @Override
  @NotNull
  public List<MIndentExpr> getIndentExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MIndentExpr.class);
  }

  @Override
  @Nullable
  public MSdedent getSdedent() {
    return findChildByClass(MSdedent.class);
  }

  @Override
  @Nullable
  public MSindent getSindent() {
    return findChildByClass(MSindent.class);
  }

  @Override
  @NotNull
  public List<MSstatementBreak> getSstatementBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MSstatementBreak.class);
  }

}
