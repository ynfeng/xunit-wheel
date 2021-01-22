package com.github.ynfeng.xunitwheel;

import java.util.List;

public abstract class TestCase {
    private final TestMethods testMethods = new TestMethods();

    public void setup() {
    }

    public void tearDown() {
    }

    public TestCaseResult run() {
        return TestCaseResult.create(testCaseName(), testMethods.run());
    }

    protected String testCaseName() {
        return getClass().getName();
    }

    public void registerTestMethod(String name, Runnable method) {
        testMethods.add(TestMethod.create(this, name, method));
    }

    protected int numOfTestMethod() {
        return testMethods.size();
    }

    protected List<String> testMethodNames() {
        return testMethods.methodNames();
    }

    protected Class<?> testClass() {
        return getClass();
    }
}
