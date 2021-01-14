package com.github.ynfeng.xunitwheel;

import java.util.HashMap;
import java.util.Map;

public class TestSuiteResult {
    private final String name;
    private final Map<Class<? extends TestCase>, TestCaseResult> testCaseResults = new HashMap<>();

    public TestSuiteResult(String name) {
        this.name = name;
    }

    public String testSuiteName() {
        return name;
    }

    public int numOfTestCaseResult() {
        return testCaseResults.size();
    }

    public void addTestCaseResult(Class<? extends TestCase> testCaseClass, TestCaseResult testCaseResult) {
        testCaseResults.put(testCaseClass, testCaseResult);
    }

    public void reportAnyFailed() throws Throwable {
        for (TestCaseResult result : testCaseResults.values()) {
            result.reportAnyFailed();
        }
    }

    public TestCaseResult testCaseResult(Class<?> testCaseClass) {
        return testCaseResults.get(testCaseClass);
    }
}
