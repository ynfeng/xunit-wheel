package com.github.ynfeng.xunitwheel;

import java.util.List;

public abstract class TestCase {
    private final TestCaseResult testCaseResult = new TestCaseResult();
    private final TestMethods testMethods;

    protected TestCase() {
        testMethods = new TestMethods(this);
    }

    public void setup() {
    }

    public void tearDown() {
    }

    public void addMethodResult(MethodResult methodResult) {
        testCaseResult.addMethodResult(methodResult);
    }

    public TestCaseResult run() {
        testMethods.run();
        return testCaseResult;
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
