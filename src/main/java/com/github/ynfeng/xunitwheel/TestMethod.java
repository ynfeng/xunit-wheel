package com.github.ynfeng.xunitwheel;

public class TestMethod {
    private final TestCase testCase;
    private final String name;
    private final Runnable method;

    public TestMethod(TestCase testCase, String name, Runnable method) {
        this.testCase = testCase;
        this.name = name;
        this.method = method;
    }

    public static TestMethod create(TestCase testCase, String name, Runnable method) {
        return new TestMethod(testCase, name, method);
    }

    public void run() {
        testCase.setup();
        method.run();
        testCase.tearDown();
    }

    public String name() {
        return name;
    }
}
