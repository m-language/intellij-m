package io.github.m.intellij.file

import com.intellij.openapi.fileTypes._

class MFileTypeFactory extends FileTypeFactory {
  override def createFileTypes(consumer: FileTypeConsumer): Unit = {
    consumer.consume(MFileType, "m")
  }
}
