package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuiteResult {
    private final String name;
    private final List<TestCaseResult> testCaseResults = new ArrayList<>();

    public TestSuiteResult(String name) {
        this.name = name;
    }

    public String testSuiteName() {
        return name;
    }

    public int numOfTestCaseResult() {
        return testCaseResults.size();
    }

    public void addTestCaseResult(TestCaseResult testCaseResult) {
        testCaseResults.add(testCaseResult);
    }

    public List<TestCaseResult> testCaseResults() {
        return Collections.unmodifiableList(testCaseResults);
    }
}
