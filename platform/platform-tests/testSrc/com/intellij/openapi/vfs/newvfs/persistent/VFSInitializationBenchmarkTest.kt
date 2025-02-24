// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.openapi.vfs.newvfs.persistent

import com.intellij.testFramework.PlatformTestUtil
import com.intellij.testFramework.junit5.TestApplication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

@TestApplication
class VFSInitializationBenchmarkTest {

  @Test
  @Throws(Exception::class)
  fun benchmarkVfsInitializationTime_CreateVfsFromScratch(@TempDir temporaryDirectory: Path) {
    PlatformTestUtil.newPerformanceTest("create VFS from scratch") {
      val cachesDir: Path = temporaryDirectory
      val version = 1

      val initializationResult = PersistentFSConnector.connectWithoutVfsLog(
        cachesDir,
        version
      )
      PersistentFSConnector.disconnect(initializationResult.connection)
    }
      .warmupIterations(1)
      .attempts(4)
      .start()
  }

  @Test
  @Throws(java.lang.Exception::class)
  fun benchmarkVfsInitializationTime_OpenExistingVfs(@TempDir temporaryDirectory: Path) {
    val cachesDir: Path = temporaryDirectory
    val version = 1
    val result = PersistentFSConnector.connectWithoutVfsLog(
      cachesDir,
      version
    )
    PersistentFSConnector.disconnect(result.connection)

    PlatformTestUtil.newPerformanceTest("open existing VFS files") {
      val initResult = PersistentFSConnector.connectWithoutVfsLog(
        cachesDir,
        version
      )
      Assertions.assertFalse(initResult.vfsCreatedAnew, "Must open existing")
      PersistentFSConnector.disconnect(initResult.connection)
    }
      .attempts(4)
      .start()
  }
}