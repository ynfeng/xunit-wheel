package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private final List<TestCase> testCases = new ArrayList<>();

    protected void registerTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public int numOfTestCase() {
        return testCases.size();
    }

    public String name() {
        return getClass().getSimpleName();
    }
}
