// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MAtomicExpr extends PsiElement {

  @Nullable
  MAtom getAtom();

  @Nullable
  MBraceExpr getBraceExpr();

  @Nullable
  MBracketExpr getBracketExpr();

  @Nullable
  MParenExpr getParenExpr();

}
