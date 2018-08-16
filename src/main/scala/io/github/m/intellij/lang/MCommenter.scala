package io.github.m.intellij.lang

import com.intellij.lang.Commenter

class MCommenter extends Commenter {
  override def getLineCommentPrefix: String = ";"

  override def getBlockCommentPrefix: String = null
  override def getBlockCommentSuffix: String = null

  override def getCommentedBlockCommentSuffix: String = null
  override def getCommentedBlockCommentPrefix: String = null
}
