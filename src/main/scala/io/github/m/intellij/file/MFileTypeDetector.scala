package io.github.m.intellij.file

import com.intellij.openapi.fileTypes._
import com.intellij.openapi.util.io.ByteSequence
import com.intellij.openapi.vfs.VirtualFile

class MFileTypeDetector extends FileTypeRegistry.FileTypeDetector {
  override def getVersion: Int = 1

  override def detect(file: VirtualFile, firstBytes: ByteSequence, firstCharsIfText: CharSequence): FileType =
    if (file.getExtension == "m") MFileType else null
}
