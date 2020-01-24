// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.m.intellij.lang.lexer.MTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // (paren_expr | brace_expr | bracket_expr) (OPEN_PAREN (whitespace* args COMMA?)* whitespace* CLOSE_PAREN)*
  public static boolean apply_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLY_EXPR, "<apply expr>");
    r = apply_expr_0(b, l + 1);
    r = r && apply_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // paren_expr | brace_expr | bracket_expr
  private static boolean apply_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_0")) return false;
    boolean r;
    r = paren_expr(b, l + 1);
    if (!r) r = brace_expr(b, l + 1);
    if (!r) r = bracket_expr(b, l + 1);
    return r;
  }

  // (OPEN_PAREN (whitespace* args COMMA?)* whitespace* CLOSE_PAREN)*
  private static boolean apply_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_expr_1", c)) break;
    }
    return true;
  }

  // OPEN_PAREN (whitespace* args COMMA?)* whitespace* CLOSE_PAREN
  private static boolean apply_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && apply_expr_1_0_1(b, l + 1);
    r = r && apply_expr_1_0_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespace* args COMMA?)*
  private static boolean apply_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_expr_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_expr_1_0_1", c)) break;
    }
    return true;
  }

  // whitespace* args COMMA?
  private static boolean apply_expr_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = apply_expr_1_0_1_0_0(b, l + 1);
    r = r && args(b, l + 1);
    r = r && apply_expr_1_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean apply_expr_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1_0_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_expr_1_0_1_0_0", c)) break;
    }
    return true;
  }

  // COMMA?
  private static boolean apply_expr_1_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1_0_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // whitespace*
  private static boolean apply_expr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_expr_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_expr_1_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (operation_expr whitespace*)+ whitespace*
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGS, "<args>");
    r = args_0(b, l + 1);
    r = r && args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (operation_expr whitespace*)+
  private static boolean args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = args_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!args_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // operation_expr whitespace*
  private static boolean args_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operation_expr(b, l + 1);
    r = r && args_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean args_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_0_0_1", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | STRING | NUMBER
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // operation_expr ((nosspace* operation_expr)* sstatement_break (sindent (nosspace* block_expr)* sdedent)?)?
  public static boolean block_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_EXPR, "<block expr>");
    r = operation_expr(b, l + 1);
    r = r && block_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((nosspace* operation_expr)* sstatement_break (sindent (nosspace* block_expr)* sdedent)?)?
  private static boolean block_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1")) return false;
    block_expr_1_0(b, l + 1);
    return true;
  }

  // (nosspace* operation_expr)* sstatement_break (sindent (nosspace* block_expr)* sdedent)?
  private static boolean block_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_expr_1_0_0(b, l + 1);
    r = r && sstatement_break(b, l + 1);
    r = r && block_expr_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nosspace* operation_expr)*
  private static boolean block_expr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_expr_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_expr_1_0_0", c)) break;
    }
    return true;
  }

  // nosspace* operation_expr
  private static boolean block_expr_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_expr_1_0_0_0_0(b, l + 1);
    r = r && operation_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace*
  private static boolean block_expr_1_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_expr_1_0_0_0_0", c)) break;
    }
    return true;
  }

  // (sindent (nosspace* block_expr)* sdedent)?
  private static boolean block_expr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_2")) return false;
    block_expr_1_0_2_0(b, l + 1);
    return true;
  }

  // sindent (nosspace* block_expr)* sdedent
  private static boolean block_expr_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sindent(b, l + 1);
    r = r && block_expr_1_0_2_0_1(b, l + 1);
    r = r && sdedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nosspace* block_expr)*
  private static boolean block_expr_1_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_expr_1_0_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_expr_1_0_2_0_1", c)) break;
    }
    return true;
  }

  // nosspace* block_expr
  private static boolean block_expr_1_0_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_expr_1_0_2_0_1_0_0(b, l + 1);
    r = r && block_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace*
  private static boolean block_expr_1_0_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_expr_1_0_2_0_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_expr_1_0_2_0_1_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACE whitespace* (list | OPERATOR)? whitespace* CLOSE_BRACE | atom
  public static boolean brace_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BRACE_EXPR, "<brace expr>");
    r = brace_expr_0(b, l + 1);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPEN_BRACE whitespace* (list | OPERATOR)? whitespace* CLOSE_BRACE
  private static boolean brace_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && brace_expr_0_1(b, l + 1);
    r = r && brace_expr_0_2(b, l + 1);
    r = r && brace_expr_0_3(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean brace_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_expr_0_1", c)) break;
    }
    return true;
  }

  // (list | OPERATOR)?
  private static boolean brace_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr_0_2")) return false;
    brace_expr_0_2_0(b, l + 1);
    return true;
  }

  // list | OPERATOR
  private static boolean brace_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr_0_2_0")) return false;
    boolean r;
    r = list(b, l + 1);
    if (!r) r = consumeToken(b, OPERATOR);
    return r;
  }

  // whitespace*
  private static boolean brace_expr_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_expr_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET whitespace* (list | OPERATOR)? whitespace* CLOSE_BRACKET | atom
  public static boolean bracket_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BRACKET_EXPR, "<bracket expr>");
    r = bracket_expr_0(b, l + 1);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPEN_BRACKET whitespace* (list | OPERATOR)? whitespace* CLOSE_BRACKET
  private static boolean bracket_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACKET);
    r = r && bracket_expr_0_1(b, l + 1);
    r = r && bracket_expr_0_2(b, l + 1);
    r = r && bracket_expr_0_3(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean bracket_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_expr_0_1", c)) break;
    }
    return true;
  }

  // (list | OPERATOR)?
  private static boolean bracket_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr_0_2")) return false;
    bracket_expr_0_2_0(b, l + 1);
    return true;
  }

  // list | OPERATOR
  private static boolean bracket_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr_0_2_0")) return false;
    boolean r;
    r = list(b, l + 1);
    if (!r) r = consumeToken(b, OPERATOR);
    return r;
  }

  // whitespace*
  private static boolean bracket_expr_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_expr_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (whitespace* block_expr)* whitespace*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespace* block_expr)*
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0", c)) break;
    }
    return true;
  }

  // whitespace* block_expr
  private static boolean file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0_0_0(b, l + 1);
    r = r && block_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean file_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean file_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (operation_expr whitespace*)+ whitespace*
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST, "<list>");
    r = list_0(b, l + 1);
    r = r && list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (operation_expr whitespace*)+
  private static boolean list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // operation_expr whitespace*
  private static boolean list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operation_expr(b, l + 1);
    r = r && list_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean list_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_0_0_1", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SPACE | TAB | NEWLINE
  public static boolean nosspace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nosspace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOSSPACE, "<nosspace>");
    r = consumeToken(b, SPACE);
    if (!r) r = consumeToken(b, TAB);
    if (!r) r = consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // apply_expr (whitespace* OPERATOR whitespace* operation_expr)?
  public static boolean operation_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATION_EXPR, "<operation expr>");
    r = apply_expr(b, l + 1);
    r = r && operation_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* OPERATOR whitespace* operation_expr)?
  private static boolean operation_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_expr_1")) return false;
    operation_expr_1_0(b, l + 1);
    return true;
  }

  // whitespace* OPERATOR whitespace* operation_expr
  private static boolean operation_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operation_expr_1_0_0(b, l + 1);
    r = r && consumeToken(b, OPERATOR);
    r = r && operation_expr_1_0_2(b, l + 1);
    r = r && operation_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean operation_expr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_expr_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "operation_expr_1_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean operation_expr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation_expr_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "operation_expr_1_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_PAREN whitespace* (args | OPERATOR)? whitespace* CLOSE_PAREN | atom
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAREN_EXPR, "<paren expr>");
    r = paren_expr_0(b, l + 1);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPEN_PAREN whitespace* (args | OPERATOR)? whitespace* CLOSE_PAREN
  private static boolean paren_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && paren_expr_0_1(b, l + 1);
    r = r && paren_expr_0_2(b, l + 1);
    r = r && paren_expr_0_3(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean paren_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_expr_0_1", c)) break;
    }
    return true;
  }

  // (args | OPERATOR)?
  private static boolean paren_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_0_2")) return false;
    paren_expr_0_2_0(b, l + 1);
    return true;
  }

  // args | OPERATOR
  private static boolean paren_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_0_2_0")) return false;
    boolean r;
    r = args(b, l + 1);
    if (!r) r = consumeToken(b, OPERATOR);
    return r;
  }

  // whitespace*
  private static boolean paren_expr_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_expr_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // nosspace* DEDENT
  public static boolean sdedent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sdedent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SDEDENT, "<sdedent>");
    r = sdedent_0(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nosspace*
  private static boolean sdedent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sdedent_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sdedent_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // nosspace* INDENT
  public static boolean sindent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sindent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINDENT, "<sindent>");
    r = sindent_0(b, l + 1);
    r = r && consumeToken(b, INDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nosspace*
  private static boolean sindent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sindent_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sindent_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STATEMENT_BREAK | INDENT | DEDENT
  public static boolean sspace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sspace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SSPACE, "<sspace>");
    r = consumeToken(b, STATEMENT_BREAK);
    if (!r) r = consumeToken(b, INDENT);
    if (!r) r = consumeToken(b, DEDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nosspace* STATEMENT_BREAK
  public static boolean sstatement_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sstatement_break")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SSTATEMENT_BREAK, "<sstatement break>");
    r = sstatement_break_0(b, l + 1);
    r = r && consumeToken(b, STATEMENT_BREAK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nosspace*
  private static boolean sstatement_break_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sstatement_break_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sstatement_break_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // sspace | nosspace
  public static boolean whitespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHITESPACE, "<whitespace>");
    r = sspace(b, l + 1);
    if (!r) r = nosspace(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
