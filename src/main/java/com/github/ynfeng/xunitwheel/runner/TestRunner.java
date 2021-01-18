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

    public void run() {
        try {
            TestSuiteResult testSuiteResult = testSuite.run();
            TestResultPrinter.printResult(testSuiteResult);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new TestRunner(args[0]).run();
    }
}
