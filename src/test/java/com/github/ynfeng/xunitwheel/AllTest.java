package com.github.ynfeng.xunitwheel;


import com.github.ynfeng.xunitwheel.annotation.AnnotationTestCaseScannerTest;
import com.github.ynfeng.xunitwheel.runner.TestSuiteRunnerTest;
import com.github.ynfeng.xunitwheel.utils.ClassScannerTest;

public class AllTest extends TestSuite {
    public AllTest() {
        registerTestCase(new AssertionsTest());
        registerTestCase(new TestSuiteTest());
        registerTestCase(new ClassScannerTest());
        registerTestCase(new AnnotationTestCaseScannerTest());
        registerTestCase(new TestSuiteRunnerTest());
    }
}
