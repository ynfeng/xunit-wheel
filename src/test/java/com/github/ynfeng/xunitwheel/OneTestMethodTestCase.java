package com.github.ynfeng.xunitwheel;

public class OneTestMethodTestCase extends TestCase {
    public String methodRunLog = "";

    public OneTestMethodTestCase() {
        registerTestMethod("method1", this::method1);
    }

    public void method1() {
        methodRunLog += "method1";
    }
}
