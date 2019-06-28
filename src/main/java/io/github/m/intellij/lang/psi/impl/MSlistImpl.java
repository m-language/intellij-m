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

public class MSlistImpl extends ASTWrapperPsiElement implements MSlist {

  public MSlistImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MVisitor visitor) {
    visitor.visitSlist(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MVisitor) accept((MVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MIexpr> getIexprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MIexpr.class);
  }

  @Override
  @NotNull
  public List<MNosspace> getNosspaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MNosspace.class);
  }

}
