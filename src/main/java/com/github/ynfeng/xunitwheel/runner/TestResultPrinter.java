package com.github.ynfeng.xunitwheel.runner;

import com.github.ynfeng.xunitwheel.TestCaseResult;
import com.github.ynfeng.xunitwheel.TestSuiteResult;
import java.io.PrintStream;
import java.util.List;

public final class TestResultPrinter {
    private PrintStream printStream = System.out;
    private static final TestResultPrinter INSTANCE = new TestResultPrinter();

    private TestResultPrinter() {
    }

    public static void printResult(TestSuiteResult testSuiteResult) {
        List<TestCaseResult> testCaseResults = testSuiteResult.testCaseResults();
        testCaseResults.forEach(caseResult -> {
            INSTANCE.printStream.printf("Running %s%n", caseResult.testCaseName());
            INSTANCE.printStream.printf("Tests run: %d, Failures: %d%n", caseResult.numOfTestMethod(), caseResult.numOfFailedMethod());
        });
    }

    public static void setPrintStream(PrintStream printStream) {
        INSTANCE.printStream = printStream;
    }
}
