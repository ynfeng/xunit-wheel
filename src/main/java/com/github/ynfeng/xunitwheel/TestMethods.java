package com.github.ynfeng.xunitwheel;

public class TestMethods {
    public boolean methodRun;

    public void run() {
        method1();
    }

    public void method1() {
        methodRun = true;
    }
}
