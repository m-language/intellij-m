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

public class MApplyExprImpl extends ASTWrapperPsiElement implements MApplyExpr {

  public MApplyExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MVisitor visitor) {
    visitor.visitApplyExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MVisitor) accept((MVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MArgs> getArgsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MArgs.class);
  }

  @Override
  @Nullable
  public MBraceExpr getBraceExpr() {
    return findChildByClass(MBraceExpr.class);
  }

  @Override
  @Nullable
  public MBracketExpr getBracketExpr() {
    return findChildByClass(MBracketExpr.class);
  }

  @Override
  @Nullable
  public MParenExpr getParenExpr() {
    return findChildByClass(MParenExpr.class);
  }

  @Override
  @NotNull
  public List<MWhitespace> getWhitespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MWhitespace.class);
  }

}
