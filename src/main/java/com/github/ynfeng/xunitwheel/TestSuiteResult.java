package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSuiteResult {
    private final Map<Class<?>, TestCaseResult> testCaseResults = new HashMap<>();

    public int numOfTestCaseResult() {
        return testCaseResults.size();
    }

    public void addTestCaseResult(Class<?> testCaseClass, TestCaseResult testCaseResult) {
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

    public List<TestCaseResult> testCaseResults() {
        return Collections.unmodifiableList(new ArrayList<>(testCaseResults.values()));
    }
}
