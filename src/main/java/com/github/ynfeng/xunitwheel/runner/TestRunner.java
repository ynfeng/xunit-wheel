package com.github.ynfeng.xunitwheel.runner;

import com.github.ynfeng.xunitwheel.TestSuite;
import com.github.ynfeng.xunitwheel.TestSuiteResult;

public class TestRunner {

    private final TestSuite testSuite;

    public TestRunner(String testSuiteClass) {
        try {
            testSuite = (TestSuite) Class.forName(testSuiteClass).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void run() throws Throwable {
        TestSuiteResult testSuiteResult = testSuite.run();
        TestResultPrinter.printResult(testSuiteResult);
        testSuiteResult.reportAnyFailed();
    }

    public static void main(String[] args) throws Throwable {
        new TestRunner(args[0]).run();
    }
}
