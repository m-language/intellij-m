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

OPEN_PAREN="("
CLOSE_PAREN=")"

IDENTIFIER=[^() \t\r\n_\\]+
NUMBER="-"?[0-9\.]+{IDENTIFIER}?

WHITE_SPACE=[\ \n\r\t\f]+
COMMENT=";"[^\r\n]*
DOC_COMMENT=";;"[^\r\n]*

STRING=\"{STRING_CHARACTER}*\"?
STRING_CHARACTER="\\".|[^\"\\]

CHAR=\\.

%%

{OPEN_PAREN} { return MTokenTypes.OPEN_PAREN; }
{CLOSE_PAREN} { return MTokenTypes.CLOSE_PAREN; }

{WHITE_SPACE} { return TokenType.WHITE_SPACE; }
{DOC_COMMENT} { return MTokens.DOC_COMMENT; }
{COMMENT} { return MTokens.COMMENT; }

{STRING} { return MTokenTypes.STRING; }
{CHAR} { return MTokenTypes.CHAR; }
{NUMBER} { return MTokenTypes.NUMBER; }
{IDENTIFIER} { return MTokenTypes.IDENTIFIER; }

[^] { return TokenType.BAD_CHARACTER; }
