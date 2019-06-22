package io.github.m.intellij.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import io.github.m.intellij.lang.lexer.*;

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
%}

WHITE_SPACE=[\ \n\r\t\f]+
COMMENT=";"[^\r\n]*
DOC_COMMENT=";;"[^\r\n]*
TITLE_COMMENT=";;;"[^\r\n]*

NUMBER="-"?[0-9\.]+{IDENTIFIER}?
STRING=\" ("\"\"" | [^\"])* \"
IDENTIFIER=[^(){}\[\] \t\r\n\"\;]+

%%

"(" { return MTokenTypes.OPEN_PAREN; }
//"{" { return MTokenTypes.OPEN_BRACE; }
//"[" { return MTokenTypes.OPEN_BRACKET; }
")" { return MTokenTypes.CLOSE_PAREN; }
//"}" { return MTokenTypes.CLOSE_BRACE; }
//"]" { return MTokenTypes.CLOSE_BRACKET; }

{WHITE_SPACE} { return TokenType.WHITE_SPACE; }
{TITLE_COMMENT} { return MTokens.TITLE_COMMENT; }
{DOC_COMMENT} { return MTokens.DOC_COMMENT; }
{COMMENT} { return MTokens.COMMENT; }

{NUMBER} { return MTokenTypes.NUMBER; }
{STRING} { return MTokenTypes.STRING; }
{IDENTIFIER} { return MTokenTypes.IDENTIFIER; }

[^] { return TokenType.BAD_CHARACTER; }
