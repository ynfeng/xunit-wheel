package com.github.ynfeng.xunitwheel;

public class TestAll extends TestCase {
    private static final String[] ARGS = {};

    public TestAll() {
        registerTestMethod("TestCaseTest", () -> TestCaseTest.main(ARGS));
        registerTestMethod("AssertionsTest", () -> AssertionsTest.main(ARGS));
    }

    public static void main(String[] args) {
        new TestAll().run();
    }
}
