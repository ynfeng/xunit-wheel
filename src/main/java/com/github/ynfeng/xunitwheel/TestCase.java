package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private final List<Runnable> testMethods = new ArrayList<>();

    public void registerTestMethod(String name, Runnable runnable) {
        testMethods.add(runnable);
    }

    public void run() {
        testMethods.forEach(Runnable::run);
    }
}
