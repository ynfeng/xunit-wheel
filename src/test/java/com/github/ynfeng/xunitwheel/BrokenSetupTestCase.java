package com.github.ynfeng.xunitwheel;

public class BrokenSetupTestCase extends TestCase {
    public String methodLog = "";

    public BrokenSetupTestCase() {
        registerTestMethod("method1", this::method1);
        registerTestMethod("method2", this::method2);
    }

    @Override
    public void setup() {
        methodLog += " setup";
        throw new RuntimeException("broken setup");
    }

    public void method1() {
        methodLog += " method1";
    }

    public void method2() {
        methodLog += " method2";
    }
}
