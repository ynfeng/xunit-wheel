package com.github.ynfeng.xunitwheel;

import java.util.List;

public class TestCase {
    private final TestMethods testMethods = new TestMethods();

    protected void registerTestMethod(String name, Runnable runnable) {
        testMethods.add(TestMethod.create(name, runnable));
    }

    public TestResult run() {
        return testMethods.run();
    }

    protected int numOfTestMethod() {
        return testMethods.size();
    }

    protected List<String> testMethodNames() {
        return testMethods.methodNames();
    }
}
