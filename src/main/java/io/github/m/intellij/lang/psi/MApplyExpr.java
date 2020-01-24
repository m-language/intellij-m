// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MApplyExpr extends PsiElement {

  @NotNull
  List<MArgs> getArgsList();

  @Nullable
  MBraceExpr getBraceExpr();

  @Nullable
  MBracketExpr getBracketExpr();

  @Nullable
  MParenExpr getParenExpr();

  @NotNull
  List<MWhitespace> getWhitespaceList();

}
