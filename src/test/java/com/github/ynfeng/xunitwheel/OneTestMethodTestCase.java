package com.github.ynfeng.xunitwheel;

public class OneTestMethodTestCase extends TestCase {
    public String methodRunLog = "";

    public void method1() {
        methodRunLog += "method1";
    }
}
