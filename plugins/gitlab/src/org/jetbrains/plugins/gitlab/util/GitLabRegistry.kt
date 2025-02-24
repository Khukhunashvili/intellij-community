// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.plugins.gitlab.util

import com.intellij.diff.editor.DiffEditorViewerFileEditor
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.util.registry.Registry
import com.intellij.openapi.util.registry.RegistryValue
import com.intellij.openapi.util.registry.RegistryValueListener
import org.jetbrains.plugins.gitlab.mergerequest.file.GitLabMergeRequestDiffFile

object GitLabRegistry {
  fun isCombinedDiffEnabled(): Boolean = Registry.`is`("gitlab.enable.combined.diff")
  fun getRequestPollingIntervalMillis(): Int = Registry.intValue("gitlab.request.polling.interval.millis")
  fun getRequestPollingAttempts(): Int = Registry.intValue("gitlab.request.polling.attempts")
}

class GitLabRegistryValueListener : RegistryValueListener {
  override fun afterValueChanged(value: RegistryValue) {
    if (value.key == "gitlab.enable.combined.diff") {
      for (project in ProjectManager.getInstance().openProjects) {
        DiffEditorViewerFileEditor.reloadDiffEditorsForFiles(project) { it is GitLabMergeRequestDiffFile }
      }
    }
  }
}
