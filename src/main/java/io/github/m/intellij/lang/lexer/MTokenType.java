package io.github.m.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import io.github.m.intellij.lang.MLanguage;
import org.jetbrains.annotations.*;

public class MTokenType extends IElementType {
    public MTokenType(@NotNull String debugName) {
        super(debugName, MLanguage.INSTANCE);
    }
}
