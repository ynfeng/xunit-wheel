package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;

public class OneTestMethodTestCase {
    public String methodRunLog = "";
    private final List<Runnable> testMethods = new ArrayList<>();

    public OneTestMethodTestCase() {
        testMethods.add(this::method1);
    }

    public void run() {
        testMethods.forEach(Runnable::run);
    }

    public void method1() {
        methodRunLog += "method1";
    }
}
