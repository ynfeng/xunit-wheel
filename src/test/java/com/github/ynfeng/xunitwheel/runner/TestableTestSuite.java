package com.github.ynfeng.xunitwheel.runner;

import com.github.ynfeng.xunitwheel.fixture.BrokenTestCase;
import com.github.ynfeng.xunitwheel.fixture.SingleTestMethodTestCase;
import com.github.ynfeng.xunitwheel.TestSuite;

public class TestableTestSuite extends TestSuite {
    public TestableTestSuite() {
        registerTestCase(new SingleTestMethodTestCase());
        registerTestCase(new BrokenTestCase());
    }
}
