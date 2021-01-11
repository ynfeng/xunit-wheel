package com.github.ynfeng.xunitwheel;

public class TestMethod {
    private final String name;
    private final Runnable runnable;

    public TestMethod(String name, Runnable runnable) {
        this.name = name;
        this.runnable = runnable;
    }

    public static TestMethod create(String name, Runnable runnable) {
        return new TestMethod(name, runnable);
    }

    public void run() {
        runnable.run();
    }

    public String name() {
        return name;
    }
}
