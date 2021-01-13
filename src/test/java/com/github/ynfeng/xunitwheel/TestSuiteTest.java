package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

public class TestSuiteTest extends TestCase {
    public TestSuiteTest() {
        registerTestMethod("should_create_test_suite", this::should_register_test_cases);
        registerTestMethod("should_run_test_suite", this::should_run_test_suite);
    }

    public void should_register_test_cases() {
        TestSuite testSuite = new TestSuite("a test suite");
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new SingleTestMethodTestCase());

        assertEquals(2, testSuite.numOfTestCase());
        assertEquals("a test suite", testSuite.name());
    }

    public void should_run_test_suite() {
        TestSuite testSuite = new TestSuite("a test suite");
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new BrokenTestCase());

        TestSuiteResult testSuiteResult = testSuite.run();

        assertEquals("a test suite", testSuiteResult.testSuiteName());
        assertEquals(2, testSuiteResult.numOfTestCaseResult());
        assertEquals(new MultiTestMethodTestCase().run(), testSuiteResult.testCaseResults().get(0));
        assertEquals(new BrokenTestCase().run(), testSuiteResult.testCaseResults().get(1));
    }

    public static void main(String[] args) throws Throwable {
        new TestSuiteTest().run().reportAnyFailed();
    }
}
