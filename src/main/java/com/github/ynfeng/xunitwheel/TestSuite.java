package com.github.ynfeng.xunitwheel;

public class TestSuite {

    protected void registerTestCase(TestCase testCase) {

    }

    public int numOfTestCase() {
        return 2;
    }

    public String name() {
        return getClass().getSimpleName();
    }
}
