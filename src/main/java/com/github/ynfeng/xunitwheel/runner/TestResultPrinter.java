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
            printSummary(caseResult);
            printDetail(caseResult);
        });
    }

    private static void printSummary(TestCaseResult caseResult) {
        INSTANCE.printStream.printf("%nRunning %s%n", caseResult.testCaseName());
        if (caseResult.hasFailedMethod()) {
            INSTANCE.printStream.printf("Tests run: %d, Failures: %d%n", caseResult.numOfTestMethod(), caseResult.numOfFailedMethod());
        } else {
            INSTANCE.printStream.printf("Tests run: %d, Failures: %d%n", caseResult.numOfTestMethod(), caseResult.numOfFailedMethod());
        }
    }

    private static void printDetail(TestCaseResult caseResult) {
        caseResult.methodResults()
            .forEach(methodResult -> {
                INSTANCE.printStream.printf("> %s %s %n", methodResult.methodName(), renderMethodResult(methodResult));
            });
    }

    private static String renderMethodResult(com.github.ynfeng.xunitwheel.MethodResult methodResult) {
        return methodResult.isSuccess() ? "\u001b[38;5;84mSUCCESS\u001b[0m" : "\u001b[38;5;196mFAILED\u001b[0m";
    }

    public static void redirectOutputStream(PrintStream printStream) {
        INSTANCE.printStream = printStream;
    }
}
