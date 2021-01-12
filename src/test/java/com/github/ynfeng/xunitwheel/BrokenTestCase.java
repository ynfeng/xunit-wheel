package com.github.ynfeng.xunitwheel;

public class BrokenTestCase extends TestCase {

    public BrokenTestCase() {
        registerTestMethod("brokenMethod", this::brokenMethod);
    }

    public void brokenMethod() {
        throw new RuntimeException();
    }

}
