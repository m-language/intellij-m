package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;

public class MTokens {
    public static final IElementType COMMENT = new MTokenType("COMMENT");
    public static final IElementType DOC_COMMENT = new MTokenType("DOC_COMMENT");
    public static final IElementType TITLE_COMMENT = new MElementType("TITLE_COMMENT");
}
