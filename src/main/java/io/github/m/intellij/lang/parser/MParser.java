// This is a generated file. Not intended for manual editing.
package io.github.m.intellij.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.m.intellij.lang.lexer.MTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
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
    if (t instanceof IFileElementType) {
      r = parse_root_(t, b, 0);
    }
    else {
      r = false;
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // atom OPEN_BRACE (whitespace* expr)* whitespace* CLOSE_BRACE
  public static boolean apply_brace_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLY_BRACE_LIST, "<apply brace list>");
    r = atom(b, l + 1);
    r = r && consumeToken(b, OPEN_BRACE);
    r = r && apply_brace_list_2(b, l + 1);
    r = r && apply_brace_list_3(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* expr)*
  private static boolean apply_brace_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_brace_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_brace_list_2", c)) break;
    }
    return true;
  }

  // whitespace* expr
  private static boolean apply_brace_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = apply_brace_list_2_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean apply_brace_list_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_list_2_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_brace_list_2_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean apply_brace_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_brace_list_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_brace_list_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // atom OPEN_BRACKET (whitespace* expr)* whitespace* CLOSE_BRACKET
  public static boolean apply_bracket_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLY_BRACKET_LIST, "<apply bracket list>");
    r = atom(b, l + 1);
    r = r && consumeToken(b, OPEN_BRACKET);
    r = r && apply_bracket_list_2(b, l + 1);
    r = r && apply_bracket_list_3(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* expr)*
  private static boolean apply_bracket_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_bracket_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_bracket_list_2", c)) break;
    }
    return true;
  }

  // whitespace* expr
  private static boolean apply_bracket_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = apply_bracket_list_2_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean apply_bracket_list_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_list_2_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_bracket_list_2_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean apply_bracket_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_bracket_list_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_bracket_list_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // atom OPEN_PAREN (whitespace* expr)* whitespace* CLOSE_PAREN
  public static boolean apply_paren_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLY_PAREN_LIST, "<apply paren list>");
    r = atom(b, l + 1);
    r = r && consumeToken(b, OPEN_PAREN);
    r = r && apply_paren_list_2(b, l + 1);
    r = r && apply_paren_list_3(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (whitespace* expr)*
  private static boolean apply_paren_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!apply_paren_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_paren_list_2", c)) break;
    }
    return true;
  }

  // whitespace* expr
  private static boolean apply_paren_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = apply_paren_list_2_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean apply_paren_list_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_list_2_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_paren_list_2_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean apply_paren_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_paren_list_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "apply_paren_list_3", c)) break;
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
  // OPEN_BRACE (whitespace* expr)* whitespace* CLOSE_BRACE
  public static boolean brace_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_list")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && brace_list_1(b, l + 1);
    r = r && brace_list_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, BRACE_LIST, r);
    return r;
  }

  // (whitespace* expr)*
  private static boolean brace_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_list_1", c)) break;
    }
    return true;
  }

  // whitespace* expr
  private static boolean brace_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_list_1_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean brace_list_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_list_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_list_1_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean brace_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "brace_list_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET (whitespace* expr)* whitespace* CLOSE_BRACKET
  public static boolean bracket_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_list")) return false;
    if (!nextTokenIs(b, OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACKET);
    r = r && bracket_list_1(b, l + 1);
    r = r && bracket_list_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACKET);
    exit_section_(b, m, BRACKET_LIST, r);
    return r;
  }

  // (whitespace* expr)*
  private static boolean bracket_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_list_1", c)) break;
    }
    return true;
  }

  // whitespace* expr
  private static boolean bracket_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_list_1_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean bracket_list_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_list_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_list_1_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean bracket_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bracket_list_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // paren_list | brace_list | bracket_list | apply_paren_list | apply_brace_list | apply_bracket_list | atom
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = paren_list(b, l + 1);
    if (!r) r = brace_list(b, l + 1);
    if (!r) r = bracket_list(b, l + 1);
    if (!r) r = apply_paren_list(b, l + 1);
    if (!r) r = apply_brace_list(b, l + 1);
    if (!r) r = apply_bracket_list(b, l + 1);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (whitespace* iexpr)* whitespace*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (whitespace* iexpr)*
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0", c)) break;
    }
    return true;
  }

  // whitespace* iexpr
  private static boolean file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0_0_0(b, l + 1);
    r = r && iexpr(b, l + 1);
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
  // ilist | expr
  public static boolean iexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iexpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IEXPR, "<iexpr>");
    r = ilist(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (nosspace* expr)+ nosspace* STATEMENT_BREAK (nosspace* INDENT slist* nosspace* DEDENT)?
  public static boolean ilist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ILIST, "<ilist>");
    r = ilist_0(b, l + 1);
    r = r && ilist_1(b, l + 1);
    r = r && consumeToken(b, STATEMENT_BREAK);
    r = r && ilist_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (nosspace* expr)+
  private static boolean ilist_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ilist_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ilist_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ilist_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace* expr
  private static boolean ilist_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ilist_0_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace*
  private static boolean ilist_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ilist_0_0_0", c)) break;
    }
    return true;
  }

  // nosspace*
  private static boolean ilist_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ilist_1", c)) break;
    }
    return true;
  }

  // (nosspace* INDENT slist* nosspace* DEDENT)?
  private static boolean ilist_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_3")) return false;
    ilist_3_0(b, l + 1);
    return true;
  }

  // nosspace* INDENT slist* nosspace* DEDENT
  private static boolean ilist_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ilist_3_0_0(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && ilist_3_0_2(b, l + 1);
    r = r && ilist_3_0_3(b, l + 1);
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace*
  private static boolean ilist_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_3_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ilist_3_0_0", c)) break;
    }
    return true;
  }

  // slist*
  private static boolean ilist_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_3_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!slist(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ilist_3_0_2", c)) break;
    }
    return true;
  }

  // nosspace*
  private static boolean ilist_3_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ilist_3_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ilist_3_0_3", c)) break;
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
  // OPEN_PAREN (whitespace* expr)* whitespace* CLOSE_PAREN
  public static boolean paren_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_list")) return false;
    if (!nextTokenIs(b, OPEN_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && paren_list_1(b, l + 1);
    r = r && paren_list_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, PAREN_LIST, r);
    return r;
  }

  // (whitespace* expr)*
  private static boolean paren_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!paren_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_list_1", c)) break;
    }
    return true;
  }

  // whitespace* expr
  private static boolean paren_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_list_1_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // whitespace*
  private static boolean paren_list_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_list_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_list_1_0_0", c)) break;
    }
    return true;
  }

  // whitespace*
  private static boolean paren_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!whitespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paren_list_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (nosspace* iexpr)+ | nosspace* STATEMENT_BREAK
  public static boolean slist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slist")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SLIST, "<slist>");
    r = slist_0(b, l + 1);
    if (!r) r = slist_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (nosspace* iexpr)+
  private static boolean slist_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slist_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slist_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!slist_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "slist_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace* iexpr
  private static boolean slist_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slist_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slist_0_0_0(b, l + 1);
    r = r && iexpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace*
  private static boolean slist_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slist_0_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "slist_0_0_0", c)) break;
    }
    return true;
  }

  // nosspace* STATEMENT_BREAK
  private static boolean slist_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slist_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slist_1_0(b, l + 1);
    r = r && consumeToken(b, STATEMENT_BREAK);
    exit_section_(b, m, null, r);
    return r;
  }

  // nosspace*
  private static boolean slist_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slist_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nosspace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "slist_1_0", c)) break;
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
