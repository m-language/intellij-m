// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MBraceExpr extends PsiElement {

  @Nullable
  MAtom getAtom();

  @Nullable
  MList getList();

  @NotNull
  List<MWhitespace> getWhitespaceList();

}
