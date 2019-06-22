package io.github.m.intellij.lang.lexer;

import com.intellij.lexer.FlexAdapter;

public class MLexer extends FlexAdapter {
    public MLexer() {
        super(new _MLexer());
    }
}