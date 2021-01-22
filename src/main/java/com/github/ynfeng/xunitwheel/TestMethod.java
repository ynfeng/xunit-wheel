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

    public MethodResult run() {
        try {
            testCase.setup();
            method.run();
            return MethodResult.success(name());
        } catch (Throwable t) {
            return MethodResult.failed(name(), t);
        } finally {
            try {
                testCase.tearDown();
            } catch (Throwable ignored) {
            }
        }
    }

    public String name() {
        return name;
    }
}
