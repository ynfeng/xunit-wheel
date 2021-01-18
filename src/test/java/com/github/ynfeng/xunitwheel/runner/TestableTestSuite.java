package com.github.ynfeng.xunitwheel.runner;

import com.github.ynfeng.xunitwheel.BrokenTestCase;
import com.github.ynfeng.xunitwheel.SingleTestMethodTestCase;
import com.github.ynfeng.xunitwheel.TestSuite;

public class TestableTestSuite extends TestSuite {
    public TestableTestSuite() {
        registerTestCase(new SingleTestMethodTestCase());
        registerTestCase(new BrokenTestCase());
    }
}
