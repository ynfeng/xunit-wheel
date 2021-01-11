package com.github.ynfeng.xunitwheel;

public class MultiTestMethodTestCase extends TestCase {
    public String methodRunLog = "";

    public MultiTestMethodTestCase() {
        registerTestMethod("method1", this::method1);
        registerTestMethod("method2", this::method2);
    }

    public void method1() {
        methodRunLog += "method1";
    }

    public void method2() {
        methodRunLog += " method2";
    }
}
