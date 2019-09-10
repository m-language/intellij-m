// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MIndentExpr extends PsiElement {

  @NotNull
  List<MExpr> getExprList();

  @NotNull
  List<MIndentExpr> getIndentExprList();

  @Nullable
  MSdedent getSdedent();

  @Nullable
  MSindent getSindent();

  @NotNull
  List<MSstatementBreak> getSstatementBreakList();

}
