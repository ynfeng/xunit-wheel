package com.github.ynfeng.xunitwheel.runner;

import com.github.ynfeng.xunitwheel.TestSuite;
import com.github.ynfeng.xunitwheel.fixture.BrokenTestCase;
import com.github.ynfeng.xunitwheel.fixture.SingleTestMethodTestCase;

public class TestableTestSuite extends TestSuite {
    public TestableTestSuite() {
        registerTestCase(new SingleTestMethodTestCase());
        registerTestCase(new BrokenTestCase());
    }
}
