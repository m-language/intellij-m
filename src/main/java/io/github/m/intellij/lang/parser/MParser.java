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
  // apply_paren_args | apply_brace_args | apply_bracket_args
  public static boolean apply_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLY_ARGS, "<apply args>");
    r = apply_paren_args(b, l + 1);
    if (!r) r = apply_brace_args(b, l + 1);
    if (!r) r = apply_bracket_args(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACE (brace_args COMMA?)* whitespace* CLOSE_BRACE
  public static boolean apply_brace_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_args")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && apply_brace_args_1(b, l + 1);
    r = r && apply_brace_args_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, APPLY_BRACE_ARGS, r);
    return r;
  }

  // (brace_args COMMA?)*
  private static boolean apply_brace_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_brace_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_brace_args_1", c)) break;
    }
    return true;
  }

  // brace_args COMMA?
  private static boolean apply_brace_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_args(b, l + 1);
    r = r && apply_brace_args_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean apply_brace_args_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_args_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // whitespace*
  private static boolean apply_brace_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_brace_args_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET (bracket_args COMMA?)* whitespace* CLOSE_BRACKET
  public static boolean apply_bracket_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_args")) return false;
    if (!nextTokenIs(b, OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACKET);
    r = r && apply_bracket_args_1(b, l + 1);
    r = r && apply_bracket_args_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACKET);
    exit_section_(b, m, APPLY_BRACKET_ARGS, r);
    return r;
  }

  // (bracket_args COMMA?)*
  private static boolean apply_bracket_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_bracket_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_bracket_args_1", c)) break;
    }
    return true;
  }

  // bracket_args COMMA?
  private static boolean apply_bracket_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_args(b, l + 1);
    r = r && apply_bracket_args_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean apply_bracket_args_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_args_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // whitespace*
  private static boolean apply_bracket_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_bracket_args_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_PAREN (paren_args COMMA?)* whitespace* CLOSE_PAREN
  public static boolean apply_paren_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_args")) return false;
    if (!nextTokenIs(b, OPEN_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && apply_paren_args_1(b, l + 1);
    r = r && apply_paren_args_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, APPLY_PAREN_ARGS, r);
    return r;
  }

  // (paren_args COMMA?)*
  private static boolean apply_paren_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_paren_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_paren_args_1", c)) break;
    }
    return true;
  }

  // paren_args COMMA?
  private static boolean apply_paren_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_args(b, l + 1);
    r = r && apply_paren_args_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean apply_paren_args_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_args_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // whitespace*
  private static boolean apply_paren_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_paren_args_2", c)) break;
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
  // paren_expr | brace_expr | bracket_expr | atom
  public static boolean atomic_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomic_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMIC_EXPR, "<atomic expr>");
    r = paren_expr(b, l + 1);
    if (!r) r = brace_expr(b, l + 1);
    if (!r) r = bracket_expr(b, l + 1);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (whitespace* expr)+ whitespace*
  public static boolean brace_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BRACE_ARGS, "<brace args>");
    r = brace_args_0(b, l + 1);
    r = r && brace_args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* expr)+
  private static boolean brace_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_args_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!brace_args_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_args_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace* expr
  private static boolean brace_args_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_args_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_args_0_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean brace_args_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_args_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_args_0_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean brace_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_args_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACE brace_args? CLOSE_BRACE
  public static boolean brace_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && brace_expr_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, BRACE_EXPR, r);
    return r;
  }

  // brace_args?
  private static boolean brace_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_expr_1")) return false;
    brace_args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (whitespace* expr)+ whitespace*
  public static boolean bracket_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BRACKET_ARGS, "<bracket args>");
    r = bracket_args_0(b, l + 1);
    r = r && bracket_args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* expr)+
  private static boolean bracket_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_args_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!bracket_args_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_args_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace* expr
  private static boolean bracket_args_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_args_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_args_0_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean bracket_args_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_args_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_args_0_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean bracket_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_args_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET bracket_args? CLOSE_BRACKET
  public static boolean bracket_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr")) return false;
    if (!nextTokenIs(b, OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACKET);
    r = r && bracket_expr_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACKET);
    exit_section_(b, m, BRACKET_EXPR, r);
    return r;
  }

  // bracket_args?
  private static boolean bracket_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_expr_1")) return false;
    bracket_args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nosspace* atomic_expr apply_args*
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = expr_0(b, l + 1);
    r = r && atomic_expr(b, l + 1);
    r = r && expr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nosspace*
  private static boolean expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_0", c)) break;
    }
    return true;
  }

  // apply_args*
  private static boolean expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_args(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (whitespace* indent_expr)* whitespace*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespace* indent_expr)*
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0", c)) break;
    }
    return true;
  }

  // whitespace* indent_expr
  private static boolean file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0_0_0(b, l + 1);
    r = r && indent_expr(b, l + 1);
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
  // expr+ sstatement_break (sindent (indent_expr+ | sstatement_break)* sdedent)?
  //               | expr
  public static boolean indent_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDENT_EXPR, "<indent expr>");
    r = indent_expr_0(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr+ sstatement_break (sindent (indent_expr+ | sstatement_break)* sdedent)?
  private static boolean indent_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indent_expr_0_0(b, l + 1);
    r = r && sstatement_break(b, l + 1);
    r = r && indent_expr_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr+
  private static boolean indent_expr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "indent_expr_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (sindent (indent_expr+ | sstatement_break)* sdedent)?
  private static boolean indent_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0_2")) return false;
    indent_expr_0_2_0(b, l + 1);
    return true;
  }

  // sindent (indent_expr+ | sstatement_break)* sdedent
  private static boolean indent_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sindent(b, l + 1);
    r = r && indent_expr_0_2_0_1(b, l + 1);
    r = r && sdedent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (indent_expr+ | sstatement_break)*
  private static boolean indent_expr_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!indent_expr_0_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "indent_expr_0_2_0_1", c)) break;
    }
    return true;
  }

  // indent_expr+ | sstatement_break
  private static boolean indent_expr_0_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indent_expr_0_2_0_1_0_0(b, l + 1);
    if (!r) r = sstatement_break(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // indent_expr+
  private static boolean indent_expr_0_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent_expr_0_2_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indent_expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!indent_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "indent_expr_0_2_0_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
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
  // (whitespace* expr)+ whitespace*
  public static boolean paren_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAREN_ARGS, "<paren args>");
    r = paren_args_0(b, l + 1);
    r = r && paren_args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* expr)+
  private static boolean paren_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_args_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!paren_args_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_args_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace* expr
  private static boolean paren_args_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_args_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_args_0_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean paren_args_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_args_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_args_0_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean paren_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_args_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_PAREN paren_args? CLOSE_PAREN
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIs(b, OPEN_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && paren_expr_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, PAREN_EXPR, r);
    return r;
  }

  // paren_args?
  private static boolean paren_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_1")) return false;
    paren_args(b, l + 1);
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
