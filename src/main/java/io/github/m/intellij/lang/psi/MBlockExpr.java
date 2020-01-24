// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MBlockExpr extends PsiElement {

  @NotNull
  List<MBlockExpr> getBlockExprList();

  @NotNull
  List<MNosspace> getNosspaceList();

  @NotNull
  List<MOperationExpr> getOperationExprList();

  @Nullable
  MSdedent getSdedent();

  @Nullable
  MSindent getSindent();

  @Nullable
  MSstatementBreak getSstatementBreak();

}
