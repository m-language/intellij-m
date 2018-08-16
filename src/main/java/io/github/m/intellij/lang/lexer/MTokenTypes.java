// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.m.intellij.lang.psi.impl.*;

public interface MTokenTypes {

  IElementType ATOM = new MElementType("ATOM");
  IElementType EXPR = new MElementType("EXPR");
  IElementType LIST = new MElementType("LIST");

  IElementType CHAR = new MTokenType("CHAR");
  IElementType CLOSE_PAREN = new MTokenType("CLOSE_PAREN");
  IElementType IDENTIFIER = new MTokenType("IDENTIFIER");
  IElementType NUMBER = new MTokenType("NUMBER");
  IElementType OPEN_PAREN = new MTokenType("OPEN_PAREN");
  IElementType STRING = new MTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ATOM) {
        return new MAtomImpl(node);
      }
      else if (type == EXPR) {
        return new MExprImpl(node);
      }
      else if (type == LIST) {
        return new MListImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
