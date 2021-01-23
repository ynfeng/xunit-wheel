package com.github.ynfeng.xunitwheel.fixture;

import com.github.ynfeng.xunitwheel.TestCase;

public class BrokenTestCase extends TestCase {

    public BrokenTestCase() {
        registerTestMethod("brokenMethod", this::brokenMethod);
    }

    public void brokenMethod() {
        throw new RuntimeException();
    }

}
