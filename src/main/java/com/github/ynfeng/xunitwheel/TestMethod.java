package com.github.ynfeng.xunitwheel;

public class TestMethod {
    private final TestCase testCase;
    private final String name;
    private final Runnable runnable;

    public TestMethod(TestCase testCase, String name, Runnable runnable) {
        this.testCase = testCase;
        this.name = name;
        this.runnable = runnable;
    }

    public static TestMethod create(TestCase testCase, String name, Runnable method) {
        return new TestMethod(testCase, name, method);
    }

    public void run() {
        testCase.setup();
        runnable.run();
        testCase.tearDown();
    }

    public String name() {
        return name;
    }
}
