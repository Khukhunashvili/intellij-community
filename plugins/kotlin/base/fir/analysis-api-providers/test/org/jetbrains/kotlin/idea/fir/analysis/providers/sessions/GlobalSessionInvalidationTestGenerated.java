// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.fir.analysis.providers.sessions;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.idea.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.idea.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.idea.base.test.TestRoot;
import org.junit.runner.RunWith;

/**
 * This class is generated by {@link org.jetbrains.kotlin.testGenerator.generator.TestGenerator}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("base/fir/analysis-api-providers")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("testData/sessionInvalidation")
public class GlobalSessionInvalidationTestGenerated extends AbstractGlobalSessionInvalidationTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("binaryTree")
    public void testBinaryTree() throws Exception {
        runTest("testData/sessionInvalidation/binaryTree/");
    }

    @TestMetadata("binaryTreeNoInvalidated")
    public void testBinaryTreeNoInvalidated() throws Exception {
        runTest("testData/sessionInvalidation/binaryTreeNoInvalidated/");
    }

    @TestMetadata("binaryTreeWithAdditionalEdge")
    public void testBinaryTreeWithAdditionalEdge() throws Exception {
        runTest("testData/sessionInvalidation/binaryTreeWithAdditionalEdge/");
    }

    @TestMetadata("binaryTreeWithInvalidInRoot")
    public void testBinaryTreeWithInvalidInRoot() throws Exception {
        runTest("testData/sessionInvalidation/binaryTreeWithInvalidInRoot/");
    }

    @TestMetadata("cyclical")
    public void testCyclical() throws Exception {
        runTest("testData/sessionInvalidation/cyclical/");
    }

    @TestMetadata("cyclicalWithOutsideDependency")
    public void testCyclicalWithOutsideDependency() throws Exception {
        runTest("testData/sessionInvalidation/cyclicalWithOutsideDependency/");
    }

    @TestMetadata("linear")
    public void testLinear() throws Exception {
        runTest("testData/sessionInvalidation/linear/");
    }

    @TestMetadata("linearWithCyclicalDependency")
    public void testLinearWithCyclicalDependency() throws Exception {
        runTest("testData/sessionInvalidation/linearWithCyclicalDependency/");
    }

    @TestMetadata("rhombus")
    public void testRhombus() throws Exception {
        runTest("testData/sessionInvalidation/rhombus/");
    }

    @TestMetadata("rhombusWithTwoInvalid")
    public void testRhombusWithTwoInvalid() throws Exception {
        runTest("testData/sessionInvalidation/rhombusWithTwoInvalid/");
    }
}
