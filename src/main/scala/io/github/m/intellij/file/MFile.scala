package io.github.m.intellij.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import io.github.m.intellij.lang.MLanguage

case class MFile(fileViewProvider: FileViewProvider) extends PsiFileBase(fileViewProvider, MLanguage.INSTANCE) {
  override def getFileType: FileType = MFileType
}
