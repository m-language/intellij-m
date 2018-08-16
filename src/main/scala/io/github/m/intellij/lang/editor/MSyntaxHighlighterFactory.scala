package io.github.m.intellij.lang.editor

import com.intellij.openapi.fileTypes._
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class MSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
  override def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile): SyntaxHighlighter =
    new MSyntaxHighlighter()
}
