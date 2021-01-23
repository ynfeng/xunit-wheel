package com.github.ynfeng.xunitwheel.fixture;

import com.github.ynfeng.xunitwheel.TestCase;

public class SingleTestMethodTestCase extends TestCase {
    public String methodRunLog = "";

    public SingleTestMethodTestCase() {
        registerTestMethod("method1", this::method1);
    }

    public void method1() {
        methodRunLog += "method1";
    }
}
