package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;

%%

%class _MLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%{
    public _MLexer() {
        this(null);
    }

    int depth = 0;
    StringBuffer comment = new StringBuffer();
%}

LINE_COMMENT=("#")[^(][^\r\n]*
ALPHA_CHAR=[a-zA-Z0-9_/]
SPECIAL_CHAR=[!$%&*+|:<=>?@\^~'=-]

NUMBER=[0-9][0-9\.]*
STRING=\" ("\"\"" | [^\"])* \"
IDENTIFIER={ALPHA_CHAR}({ALPHA_CHAR}|{SPECIAL_CHAR})*
OPERATOR={SPECIAL_CHAR}({ALPHA_CHAR}|{SPECIAL_CHAR})*

%state COMMENT

%%
<YYINITIAL> {
  "(" { return MTokenTypes.OPEN_PAREN; }
  ")" { return MTokenTypes.CLOSE_PAREN; }
  "[" { return MTokenTypes.OPEN_BRACE; }
  "]" { return MTokenTypes.CLOSE_BRACE; }
  "{" { return MTokenTypes.OPEN_BRACKET; }
  "}" { return MTokenTypes.CLOSE_BRACKET; }

  "," { return MTokenTypes.COMMA; }

  [ ] { return MTokenTypes.SPACE; }
  [\t] { return MTokenTypes.TAB; }
  [\n] { return MTokenTypes.NEWLINE; }

  {NUMBER} { return MTokenTypes.NUMBER; }
  {STRING} { return MTokenTypes.STRING; }
  {IDENTIFIER} { return MTokenTypes.IDENTIFIER; }
  {OPERATOR} { return MTokenTypes.OPERATOR; }

  "#(" { comment.setLength(0); yybegin(COMMENT); }
  {LINE_COMMENT} { return MTokens.COMMENT; }
}

<COMMENT> {
  "(" { depth++; return MTokens.COMMENT; }
  ")" { if (depth == 0) yybegin(YYINITIAL); else depth--; return MTokens.COMMENT; }
  [^()]+ { return MTokens.COMMENT; }
}

[^] { return TokenType.BAD_CHARACTER; }
