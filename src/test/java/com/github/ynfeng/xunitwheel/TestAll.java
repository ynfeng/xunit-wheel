package com.github.ynfeng.xunitwheel;

public class TestAll extends TestCase {

    public static void main(String[] args) {
        TestAll all = new TestAll();
        all.registerTestMethod("TestCaseTest", () -> TestCaseTest.main(args));
        all.registerTestMethod("AssertionsTest", () -> AssertionsTest.main(args));
        all.run();
    }
}
