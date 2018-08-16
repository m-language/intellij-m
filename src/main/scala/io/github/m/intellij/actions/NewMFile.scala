package io.github.m.intellij.actions

import com.intellij.CommonBundle
import com.intellij.ide.actions.CreateElementActionBase
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.psi._
import io.github.m.intellij.file.MFileType

class NewMFile extends CreateElementActionBase("Create new M file", "Create new M file", null) {
  override def getErrorTitle: String = CommonBundle.getErrorTitle

  override def getActionName(directory: PsiDirectory, newName: String): String = "New M File"

  override def create(newName: String, directory: PsiDirectory): Array[PsiElement] = {
    val psiFileFactory = PsiFileFactory.getInstance(directory.getProject)
    val psiFile = psiFileFactory.createFileFromText(
      if (newName.contains('.')) newName else s"$newName.m",
      MFileType,
      ""
    )
    val file = directory.add(psiFile).asInstanceOf[PsiFile]
    val child = file.getLastChild
    if (child != null) Array(file, child) else Array(file)
  }

  override def invokeDialog(project: Project, directory: PsiDirectory): Array[PsiElement] = {
    val validator = new MyInputValidator(project, directory)
    Messages.showInputDialog(project, "File name:", "New M File", Messages.getQuestionIcon, "", validator)
    validator.getCreatedElements
  }

  override def getCommandName: String = "New M File"
}
