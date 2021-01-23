package com.github.ynfeng.xunitwheel.runner;

import com.github.ynfeng.xunitwheel.AnnotationTestSuite;
import com.github.ynfeng.xunitwheel.TestSuiteResult;

public class AnnotationTestRunner implements Runner {

    @Override
    public void run() throws Throwable {
        AnnotationTestSuite testSuite = new AnnotationTestSuite();
        TestSuiteResult testSuiteResult = testSuite.run();
        TestResultPrinter.printResult(testSuiteResult);
        testSuiteResult.reportAnyFailed();
    }

    public static void main(String[] args) throws Throwable {
        new AnnotationTestRunner().run();
    }
}
