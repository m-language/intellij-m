package io.github.m.intellij.lang;

import com.intellij.lang.Language;

public class MLanguage extends Language {
    public static final MLanguage INSTANCE = new MLanguage();

    protected MLanguage() {
        super("M");
    }
}
