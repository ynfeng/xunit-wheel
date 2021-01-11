package com.github.ynfeng.xunitwheel;

public class MultiTestMethodTestCase extends TestCase {
    public String methodRunLog = "";

    public void method1() {
        methodRunLog += "method1";
    }

    public void method2() {
        methodRunLog += " method2";
    }
}
