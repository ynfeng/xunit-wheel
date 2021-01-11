package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;

public class MultiTestMethodTestCase {
    public String methodRunLog = "";
    private final List<Runnable> testMethods = new ArrayList<>();

    public MultiTestMethodTestCase() {
        testMethods.add(this::method1);
        testMethods.add(this::method2);
    }

    public void run() {
        testMethods.forEach(Runnable::run);
    }

    public void method1() {
        methodRunLog += "method1";
    }

    private void method2() {
        methodRunLog += " method2";
    }
}
