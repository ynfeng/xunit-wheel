package com.github.ynfeng.xunitwheel;

import java.util.List;

public abstract class TestCase {
    private final TestMethods testMethods = new TestMethods();

    public void setup() {
    }

    public void tearDown() {

    }

    protected void registerTestMethod(String name, Runnable runnable) {
        testMethods.add(TestMethod.create(this, name, runnable));
    }

    public TestCaseResult run() {
        TestCaseResult testCaseResult = new TestCaseResult();
        testMethods.run(testCaseResult);
        return testCaseResult;
    }

    protected int numOfTestMethod() {
        return testMethods.size();
    }

    protected List<String> testMethodNames() {
        return testMethods.methodNames();
    }
}
