package com.github.ynfeng.xunitwheel.fixture;

import com.github.ynfeng.xunitwheel.TestCase;

public class SetupTestCase extends TestCase {
    public String methodLog = "";

    public SetupTestCase() {
        registerTestMethod("method1", this::method1);
        registerTestMethod("method2", this::method2);
    }

    @Override
    public void setup() {
        methodLog += " setup";
    }

    public void method1() {
        methodLog += " method1";
    }

    public void method2() {
        methodLog += " method2";
    }
}
