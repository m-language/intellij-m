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

public class MOperationExprImpl extends ASTWrapperPsiElement implements MOperationExpr {

  public MOperationExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MVisitor visitor) {
    visitor.visitOperationExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MVisitor) accept((MVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MApplyExpr getApplyExpr() {
    return findNotNullChildByClass(MApplyExpr.class);
  }

  @Override
  @Nullable
  public MOperationExpr getOperationExpr() {
    return findChildByClass(MOperationExpr.class);
  }

  @Override
  @NotNull
  public List<MWhitespace> getWhitespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MWhitespace.class);
  }

}
