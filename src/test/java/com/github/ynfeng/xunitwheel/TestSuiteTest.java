package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

public class TestSuiteTest extends TestCase {
    public TestSuiteTest() {
        registerTestMethod("should_create_test_suite", this::should_create_test_suite);
    }

    public void should_create_test_suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new SingleTestMethodTestCase());

        assertEquals(testSuite.numOfTestCase(), 2);
        assertEquals(testSuite.name(), "TestSuite");
    }

    public static void main(String[] args) throws Throwable {
        new TestSuiteTest().run().reportAnyFailed();
    }
}
