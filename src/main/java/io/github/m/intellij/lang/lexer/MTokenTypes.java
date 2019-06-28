// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.m.intellij.lang.psi.impl.*;

public interface MTokenTypes {

  IElementType APPLY_BRACE_LIST = new MElementType("APPLY_BRACE_LIST");
  IElementType APPLY_BRACKET_LIST = new MElementType("APPLY_BRACKET_LIST");
  IElementType APPLY_PAREN_LIST = new MElementType("APPLY_PAREN_LIST");
  IElementType ATOM = new MElementType("ATOM");
  IElementType BRACE_LIST = new MElementType("BRACE_LIST");
  IElementType BRACKET_LIST = new MElementType("BRACKET_LIST");
  IElementType EXPR = new MElementType("EXPR");
  IElementType IEXPR = new MElementType("IEXPR");
  IElementType ILIST = new MElementType("ILIST");
  IElementType NOSSPACE = new MElementType("NOSSPACE");
  IElementType PAREN_LIST = new MElementType("PAREN_LIST");
  IElementType SLIST = new MElementType("SLIST");
  IElementType SSPACE = new MElementType("SSPACE");
  IElementType WHITESPACE = new MElementType("WHITESPACE");

  IElementType CLOSE_BRACE = new MTokenType("CLOSE_BRACE");
  IElementType CLOSE_BRACKET = new MTokenType("CLOSE_BRACKET");
  IElementType CLOSE_PAREN = new MTokenType("CLOSE_PAREN");
  IElementType DEDENT = new MTokenType("DEDENT");
  IElementType IDENTIFIER = new MTokenType("IDENTIFIER");
  IElementType INDENT = new MTokenType("INDENT");
  IElementType NEWLINE = new MTokenType("NEWLINE");
  IElementType NUMBER = new MTokenType("NUMBER");
  IElementType OPEN_BRACE = new MTokenType("OPEN_BRACE");
  IElementType OPEN_BRACKET = new MTokenType("OPEN_BRACKET");
  IElementType OPEN_PAREN = new MTokenType("OPEN_PAREN");
  IElementType SPACE = new MTokenType("SPACE");
  IElementType STATEMENT_BREAK = new MTokenType("STATEMENT_BREAK");
  IElementType STRING = new MTokenType("STRING");
  IElementType TAB = new MTokenType("TAB");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == APPLY_BRACE_LIST) {
        return new MApplyBraceListImpl(node);
      }
      else if (type == APPLY_BRACKET_LIST) {
        return new MApplyBracketListImpl(node);
      }
      else if (type == APPLY_PAREN_LIST) {
        return new MApplyParenListImpl(node);
      }
      else if (type == ATOM) {
        return new MAtomImpl(node);
      }
      else if (type == BRACE_LIST) {
        return new MBraceListImpl(node);
      }
      else if (type == BRACKET_LIST) {
        return new MBracketListImpl(node);
      }
      else if (type == EXPR) {
        return new MExprImpl(node);
      }
      else if (type == IEXPR) {
        return new MIexprImpl(node);
      }
      else if (type == ILIST) {
        return new MIlistImpl(node);
      }
      else if (type == NOSSPACE) {
        return new MNosspaceImpl(node);
      }
      else if (type == PAREN_LIST) {
        return new MParenListImpl(node);
      }
      else if (type == SLIST) {
        return new MSlistImpl(node);
      }
      else if (type == SSPACE) {
        return new MSspaceImpl(node);
      }
      else if (type == WHITESPACE) {
        return new MWhitespaceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
