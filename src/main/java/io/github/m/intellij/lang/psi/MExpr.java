// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MExpr extends PsiElement {

  @Nullable
  MApplyBraceList getApplyBraceList();

  @Nullable
  MApplyBracketList getApplyBracketList();

  @Nullable
  MApplyParenList getApplyParenList();

  @Nullable
  MAtom getAtom();

  @Nullable
  MBraceList getBraceList();

  @Nullable
  MBracketList getBracketList();

  @Nullable
  MParenList getParenList();

}
