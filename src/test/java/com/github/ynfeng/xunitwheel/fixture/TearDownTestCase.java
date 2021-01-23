package com.github.ynfeng.xunitwheel.fixture;

import com.github.ynfeng.xunitwheel.TestCase;

public class TearDownTestCase extends TestCase {
    public String methodLog = "";

    public TearDownTestCase() {
        registerTestMethod("method1", this::method1);
        registerTestMethod("method2", this::method2);
    }

    @Override
    public void setup() {
        methodLog += " setup";
    }

    @Override
    public void tearDown() {
        methodLog += " teardown";
    }

    public void method1() {
        methodLog += " method1";
    }

    public void method2() {
        methodLog += " method2";
    }
}
