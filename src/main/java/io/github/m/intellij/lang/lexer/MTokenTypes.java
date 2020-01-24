// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.m.intellij.lang.psi.impl.*;

public interface MTokenTypes {

  IElementType APPLY_EXPR = new MElementType("APPLY_EXPR");
  IElementType ARGS = new MElementType("ARGS");
  IElementType ATOM = new MElementType("ATOM");
  IElementType BLOCK_EXPR = new MElementType("BLOCK_EXPR");
  IElementType BRACE_EXPR = new MElementType("BRACE_EXPR");
  IElementType BRACKET_EXPR = new MElementType("BRACKET_EXPR");
  IElementType LIST = new MElementType("LIST");
  IElementType NOSSPACE = new MElementType("NOSSPACE");
  IElementType OPERATION_EXPR = new MElementType("OPERATION_EXPR");
  IElementType PAREN_EXPR = new MElementType("PAREN_EXPR");
  IElementType SDEDENT = new MElementType("SDEDENT");
  IElementType SINDENT = new MElementType("SINDENT");
  IElementType SSPACE = new MElementType("SSPACE");
  IElementType SSTATEMENT_BREAK = new MElementType("SSTATEMENT_BREAK");
  IElementType WHITESPACE = new MElementType("WHITESPACE");

  IElementType CLOSE_BRACE = new MTokenType("CLOSE_BRACE");
  IElementType CLOSE_BRACKET = new MTokenType("CLOSE_BRACKET");
  IElementType CLOSE_PAREN = new MTokenType("CLOSE_PAREN");
  IElementType COMMA = new MTokenType("COMMA");
  IElementType DEDENT = new MTokenType("DEDENT");
  IElementType IDENTIFIER = new MTokenType("IDENTIFIER");
  IElementType INDENT = new MTokenType("INDENT");
  IElementType NEWLINE = new MTokenType("NEWLINE");
  IElementType NUMBER = new MTokenType("NUMBER");
  IElementType OPEN_BRACE = new MTokenType("OPEN_BRACE");
  IElementType OPEN_BRACKET = new MTokenType("OPEN_BRACKET");
  IElementType OPEN_PAREN = new MTokenType("OPEN_PAREN");
  IElementType OPERATOR = new MTokenType("OPERATOR");
  IElementType SPACE = new MTokenType("SPACE");
  IElementType STATEMENT_BREAK = new MTokenType("STATEMENT_BREAK");
  IElementType STRING = new MTokenType("STRING");
  IElementType TAB = new MTokenType("TAB");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == APPLY_EXPR) {
        return new MApplyExprImpl(node);
      }
      else if (type == ARGS) {
        return new MArgsImpl(node);
      }
      else if (type == ATOM) {
        return new MAtomImpl(node);
      }
      else if (type == BLOCK_EXPR) {
        return new MBlockExprImpl(node);
      }
      else if (type == BRACE_EXPR) {
        return new MBraceExprImpl(node);
      }
      else if (type == BRACKET_EXPR) {
        return new MBracketExprImpl(node);
      }
      else if (type == LIST) {
        return new MListImpl(node);
      }
      else if (type == NOSSPACE) {
        return new MNosspaceImpl(node);
      }
      else if (type == OPERATION_EXPR) {
        return new MOperationExprImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new MParenExprImpl(node);
      }
      else if (type == SDEDENT) {
        return new MSdedentImpl(node);
      }
      else if (type == SINDENT) {
        return new MSindentImpl(node);
      }
      else if (type == SSPACE) {
        return new MSspaceImpl(node);
      }
      else if (type == SSTATEMENT_BREAK) {
        return new MSstatementBreakImpl(node);
      }
      else if (type == WHITESPACE) {
        return new MWhitespaceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
