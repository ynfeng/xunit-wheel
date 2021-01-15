package com.github.ynfeng.xunitwheel;

import java.util.List;

public abstract class TestCase {
    private final TestMethods testMethods = new TestMethods();

    public void setup() {
    }

    public void tearDown() {
    }

    public TestCaseResult run() {
        return TestCaseResult.create(testMethods.run());
    }

    protected void registerTestMethod(String name, Runnable runnable) {
        testMethods.add(TestMethod.create(this, name, runnable));
    }

    protected int numOfTestMethod() {
        return testMethods.size();
    }

    protected List<String> testMethodNames() {
        return testMethods.methodNames();
    }
}
