package com.github.ynfeng.xunitwheel;


import com.github.ynfeng.xunitwheel.annotation.AnnotationTestCaseScannerTest;
import com.github.ynfeng.xunitwheel.utils.ClassScannerTest;

public class AllTest {
    public static void main(String[] args) throws Throwable {
        TestSuite testSuite = new TestSuite("all test");
        testSuite.registerTestCase(new TestCaseTest());
        testSuite.registerTestCase(new AssertionsTest());
        testSuite.registerTestCase(new TestSuiteTest());
        testSuite.registerTestCase(new ClassScannerTest());
        testSuite.registerTestCase(new AnnotationTestCaseScannerTest());
        testSuite.run().reportAnyFailed();
    }
}
