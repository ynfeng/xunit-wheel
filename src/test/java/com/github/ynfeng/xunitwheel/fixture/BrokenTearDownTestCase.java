package com.github.ynfeng.xunitwheel.fixture;

import com.github.ynfeng.xunitwheel.TestCase;

public class BrokenTearDownTestCase extends TestCase {
    public String methodLog = "";

    public BrokenTearDownTestCase() {
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
        throw new RuntimeException("tear down broken");
    }

    public void method1() {
        methodLog += " method1";
    }

    public void method2() {
        methodLog += " method2";
    }
}
