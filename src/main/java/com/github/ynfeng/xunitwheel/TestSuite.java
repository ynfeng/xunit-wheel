package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private final List<TestCase> testCases = new ArrayList<>();
    private final String name;

    public TestSuite(String name) {
        this.name = name;
    }

    protected void registerTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public int numOfTestCase() {
        return testCases.size();
    }

    public String name() {
        return name;
    }

    public TestSuiteResult run() {
        TestSuiteResult result = new TestSuiteResult(name);
        testCases.forEach(testCase -> result.addTestCaseResult(testCase.run()));
        return result;
    }
}
