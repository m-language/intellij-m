// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MApplyBraceList extends PsiElement {

  @NotNull
  MAtom getAtom();

  @NotNull
  List<MExpr> getExprList();

  @NotNull
  List<MWhitespace> getWhitespaceList();

}
