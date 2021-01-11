package com.github.ynfeng.xunitwheel;

public class TestMethods {
    public String methodRunLog = "";

    public void run() {
        method1();
    }

    public void method1() {
        methodRunLog += "method1";
    }
}
