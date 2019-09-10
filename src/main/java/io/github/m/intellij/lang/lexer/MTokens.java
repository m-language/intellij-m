package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static io.github.m.intellij.lang.lexer.MTokenTypes.*;

public class MTokens {
    public static final IElementType COMMENT = new MTokenType("COMMENT");
    public static final IElementType DOC_COMMENT = new MTokenType("DOC_COMMENT");
    public static final IElementType TITLE_COMMENT = new MElementType("TITLE_COMMENT");
    public static final IElementType BLOCK_COMMENT = new MElementType("BLOCK_COMMENT");

    public static final TokenSet OPEN_BRACES = TokenSet.create(OPEN_PAREN);
    public static final TokenSet CLOSE_BRACES = TokenSet.create(CLOSE_PAREN);
    public static final TokenSet WHITESPACE = TokenSet.create(SPACE, TAB, NEWLINE);
}
