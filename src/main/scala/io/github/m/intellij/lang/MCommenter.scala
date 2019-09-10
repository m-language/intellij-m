package io.github.m.intellij.lang

import com.intellij.lang.Commenter

class MCommenter extends Commenter {
  override def getLineCommentPrefix: String = ";"

  override def getBlockCommentPrefix: String = "#{"
  override def getBlockCommentSuffix: String = "}"

  override def getCommentedBlockCommentSuffix: String = "}"
  override def getCommentedBlockCommentPrefix: String = "{"
}
