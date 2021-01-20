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
        INSTANCE.printStream.flush();
        List<TestCaseResult> testCaseResults = testSuiteResult.testCaseResults();
        testCaseResults.forEach(caseResult -> {
            printTitle(caseResult);
            printSummary(caseResult);
        });
    }

    private static void printTitle(TestCaseResult caseResult) {
        INSTANCE.printStream.printf("Running %s%n", caseResult.testCaseName());
    }

    private static void printSummary(TestCaseResult caseResult) {
        if (caseResult.hasFailedMethod()) {
            INSTANCE.printStream.printf("\u001b[38;5;196mTests\u001b[0m run: %d, Failures: %d%n", caseResult.numOfTestMethod(), caseResult.numOfFailedMethod());
        } else {
            INSTANCE.printStream.printf("\u001b[38;5;84mTests\u001b[0m run: %d, Failures: %d%n", caseResult.numOfTestMethod(), caseResult.numOfFailedMethod());
        }
    }

    public static void redirectOutputStream(PrintStream printStream) {
        INSTANCE.printStream = printStream;
    }
}
