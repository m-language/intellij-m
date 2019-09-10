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

public class MApplyArgsImpl extends ASTWrapperPsiElement implements MApplyArgs {

  public MApplyArgsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MVisitor visitor) {
    visitor.visitApplyArgs(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MVisitor) accept((MVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MApplyBraceArgs getApplyBraceArgs() {
    return findChildByClass(MApplyBraceArgs.class);
  }

  @Override
  @Nullable
  public MApplyBracketArgs getApplyBracketArgs() {
    return findChildByClass(MApplyBracketArgs.class);
  }

  @Override
  @Nullable
  public MApplyParenArgs getApplyParenArgs() {
    return findChildByClass(MApplyParenArgs.class);
  }

}
