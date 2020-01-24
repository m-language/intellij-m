package io.github.m.intellij.lang.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import gnu.trove.TIntStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MIndentingProcessor extends MergingLexerAdapter {
    private List<PendingToken> tokenQueue = new ArrayList<>();
    private final TIntStack indentStack = new TIntStack();

    private boolean lineHasSignificantTokens = false;

    MIndentingProcessor(FlexLexer lexer, TokenSet tokens) {
        super(new FlexAdapter(lexer), tokens);
    }

    private static class PendingToken {
        private IElementType type;
        private final int start;
        private final int end;

        private PendingToken(IElementType type, int start, int end) {
            this.type = type;
            this.start = start;
            this.end = end;
        }
    }

    private static class PendingCommentToken extends PendingToken {
        PendingCommentToken(IElementType type, int start, int end) {
            super(type, start, end);
        }
    }

    @Nullable
    private IElementType getBaseTokenType() {
        return super.getTokenType();
    }

    private int getBaseTokenStart() {
        return super.getTokenStart();
    }

    private int getBaseTokenEnd() {
        return super.getTokenEnd();
    }

    private boolean isBaseAt(IElementType tokenType) {
        return getBaseTokenType() == tokenType;
    }

    @Override
    public IElementType getTokenType() {
        if (tokenQueue.size() > 0) {
            return tokenQueue.get(0).type;
        }
        return super.getTokenType();
    }

    @Override
    public int getTokenStart() {
        if (tokenQueue.size() > 0) {
            return tokenQueue.get(0).start;
        }
        return super.getTokenStart();
    }

    @Override
    public int getTokenEnd() {
        if (tokenQueue.size() > 0) {
            return tokenQueue.get(0).end;
        }
        return super.getTokenEnd();
    }

    @Override
    public void advance() {
        if (tokenQueue.size() > 0) {
            tokenQueue.remove(0);
        } else {
            advanceBase();
            processSpecialTokens();
        }
    }

    private void advanceBase() {
        super.advance();
        checkSignificantTokens();
    }

    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        super.start(buffer, startOffset, endOffset, initialState);
        indentStack.clear();
        indentStack.push(0);
        lineHasSignificantTokens = false;
        checkSignificantTokens();
        if (isBaseAt(MTokenTypes.SPACE)) {
            processIndent(0, MTokenTypes.SPACE);
        }
    }

    private void checkSignificantTokens() {
        IElementType tokenType = getBaseTokenType();
        if (!MTokens.WHITESPACE.contains(tokenType) && !isCommentTokenType(tokenType)) {
            lineHasSignificantTokens = true;
        }
    }

    private void processSpecialTokens() {
        int tokenStart = getBaseTokenStart();
        if (isBaseAt(MTokenTypes.NEWLINE)) {
            processLineBreak(tokenStart);
            if (isCommentTokenType(getBaseTokenType())) {
                while (isCommentTokenType(getBaseTokenType())) {
                    final int commentEnd = getBaseTokenEnd();
                    tokenQueue.add(new PendingCommentToken(getBaseTokenType(), getBaseTokenStart(), commentEnd));
                    advanceBase();
                    if (isBaseAt(MTokenTypes.NEWLINE)) {
                        processLineBreak(getBaseTokenStart());
                    }
                    else if (getBaseTokenType() == null) {
                        closeDanglingSuitesWithComments(0, commentEnd);
                    } else {
                        break;
                    }
                }
            }
        } else if (isBaseAt(MTokenTypes.SPACE)) {
            processSpace();
        }
    }

    private void processSpace() {
        int start = getBaseTokenStart();
        int end = getBaseTokenEnd();
        while (getBaseTokenType() == MTokenTypes.SPACE) {
            end = getBaseTokenEnd();
            advanceBase();
        }
        if (getBaseTokenType() == MTokenTypes.NEWLINE) {
            processLineBreak(start);
        } else {
            tokenQueue.add(new PendingToken(MTokenTypes.SPACE, start, end));
        }
    }

    private void processLineBreak(int startPos) {
            if (lineHasSignificantTokens) {
                tokenQueue.add(new PendingToken(MTokenTypes.STATEMENT_BREAK, startPos, startPos));
            }
            lineHasSignificantTokens = false;
            advanceBase();
            processIndent(startPos, MTokenTypes.NEWLINE);
    }

    private void processIndent(int whiteSpaceStart, IElementType whitespaceTokenType) {
        int lastIndent = indentStack.peek();
        int indent = getNextLineIndent();
        if (isCommentTokenType(getBaseTokenType())) {
            indent = lastIndent;
        }
        int whiteSpaceEnd = (getBaseTokenType() == null) ? super.getBufferEnd() : getBaseTokenStart();
        if (indent > lastIndent) {
            indentStack.push(indent);
            tokenQueue.add(new PendingToken(whitespaceTokenType, whiteSpaceStart, whiteSpaceEnd));
            int insertIndex = skipPrecedingCommentsWithIndent(tokenQueue.size() - 1);
            int indentOffset = insertIndex == tokenQueue.size() ? whiteSpaceEnd : tokenQueue.get(insertIndex).start;
            tokenQueue.add(insertIndex, new PendingToken(MTokenTypes.INDENT, indentOffset, indentOffset));
        } else if (indent < lastIndent) {
            closeDanglingSuitesWithComments(indent, whiteSpaceStart);
            tokenQueue.add(new PendingToken(whitespaceTokenType, whiteSpaceStart, whiteSpaceEnd));
        } else {
            tokenQueue.add(new PendingToken(whitespaceTokenType, whiteSpaceStart, whiteSpaceEnd));
        }
    }

    private void closeDanglingSuitesWithComments(int indent, int whiteSpaceStart) {
        int lastIndent = indentStack.peek();
        int insertIndex = tokenQueue.size();
        while (indent < lastIndent) {
            indentStack.pop();
            lastIndent = indentStack.peek();
            int dedentOffset = whiteSpaceStart;
            if (indent > lastIndent) {
                tokenQueue.add(new PendingToken(MTokenTypes.DEDENT, whiteSpaceStart, whiteSpaceStart));
                insertIndex = tokenQueue.size();
            } else {
                insertIndex = skipPrecedingCommentsWithSameIndentOnSuiteClose(insertIndex);
            }
            if (insertIndex != tokenQueue.size()) {
                dedentOffset = tokenQueue.get(insertIndex).start;
            }
            tokenQueue.add(insertIndex, new PendingToken(MTokenTypes.DEDENT, dedentOffset, dedentOffset));
            insertIndex++;
        }
    }

    private int skipPrecedingCommentsWithIndent(int index) {
        boolean foundComment = false;
        while (index > 0 && tokenQueue.get(index - 1) instanceof PendingCommentToken) {
            foundComment = true;
            index--;
            if (index > 1 &&
                    tokenQueue.get(index - 1).type == MTokenTypes.NEWLINE &&
                    tokenQueue.get(index - 2) instanceof PendingCommentToken) {
                index--;
            }
        }
        return foundComment ? index : tokenQueue.size();
    }

    private int skipPrecedingCommentsWithSameIndentOnSuiteClose(int anchorIndex) {
        int result = anchorIndex;
        for (int i = anchorIndex; i < tokenQueue.size(); i++) {
            final PendingToken token = tokenQueue.get(i);
            if (token instanceof PendingCommentToken) {
                result = i + 1;
            }
        }
        return result;
    }

    private int getNextLineIndent() {
        int indent = 0;
        while (getBaseTokenType() != null && MTokens.WHITESPACE.contains(getBaseTokenType())) {
            if (getBaseTokenType() == MTokenTypes.TAB) {
                indent = ((indent / 8) + 1) * 8;
            } else if (getBaseTokenType() == MTokenTypes.SPACE) {
                indent++;
            } else if (getBaseTokenType() == MTokenTypes.NEWLINE) {
                indent = 0;
            }
            advanceBase();
        }
        if (getBaseTokenType() == null) {
            return 0;
        }
        return indent;
    }

    private boolean isCommentTokenType(IElementType elementType) {
        return elementType == MTokens.COMMENT;
    }
}