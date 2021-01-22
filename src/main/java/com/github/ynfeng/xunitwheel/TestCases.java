package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;

public class TestCases {
    private final List<TestCase> cases = new ArrayList<>();

    public void add(TestCase testCase) {
        cases.add(testCase);
    }

    public int size() {
        return cases.size();
    }

    public void run(TestSuiteResult result) {
        cases.forEach(testCase -> result.addTestCaseResult(testCase.testClass(), testCase.run()));
    }
}
