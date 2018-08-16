package io.github.m.intellij.file

import javax.swing.Icon

import com.intellij.openapi.fileTypes.LanguageFileType
import icons.MPluginIcons
import io.github.m.intellij.lang.MLanguage

object MFileType extends LanguageFileType(MLanguage.INSTANCE) {
  override def getName: String = "M"

  override def getDescription: String = "The M programming language"

  override def getIcon: Icon = MPluginIcons.M_ICON

  override def getDefaultExtension: String = ".m"
}
