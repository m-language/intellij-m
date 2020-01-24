// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MOperationExpr extends PsiElement {

  @NotNull
  MApplyExpr getApplyExpr();

  @Nullable
  MOperationExpr getOperationExpr();

  @NotNull
  List<MWhitespace> getWhitespaceList();

}
