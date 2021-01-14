package com.github.ynfeng.xunitwheel;

public class AllTest {
    public static void main(String[] args) throws Throwable {
        TestSuite testSuite = new TestSuite("all test");
        testSuite.registerTestCase(new TestCaseTest());
        testSuite.registerTestCase(new AssertionsTest());
        testSuite.registerTestCase(new TestSuiteTest());
        testSuite.run().reportAnyFailed();
    }
}
