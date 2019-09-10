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

public class MApplyBracketArgsImpl extends ASTWrapperPsiElement implements MApplyBracketArgs {

  public MApplyBracketArgsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MVisitor visitor) {
    visitor.visitApplyBracketArgs(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MVisitor) accept((MVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MBracketArgs> getBracketArgsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MBracketArgs.class);
  }

  @Override
  @NotNull
  public List<MWhitespace> getWhitespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MWhitespace.class);
  }

}
