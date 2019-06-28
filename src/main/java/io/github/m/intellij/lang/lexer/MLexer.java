package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.TokenSet;

public class MLexer extends MIndentingProcessor {
    public MLexer() {
        super(new _MLexer(), TokenSet.EMPTY);
    }
}
