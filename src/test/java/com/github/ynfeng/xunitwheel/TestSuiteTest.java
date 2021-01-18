package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

public class TestSuiteTest extends TestCase {
    public TestSuiteTest() {
        registerTestMethod("should_create_test_suite", this::should_register_test_cases);
        registerTestMethod("should_run_test_suite", this::should_run_test_suite);
    }

    public void should_register_test_cases() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new SingleTestMethodTestCase());

        assertEquals(2, testSuite.numOfTestCase());
    }

    public void should_run_test_suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new BrokenTestCase());

        TestSuiteResult testSuiteResult = testSuite.run();

        assertEquals(2, testSuiteResult.numOfTestCaseResult());

        TestCaseResult multiMethodTestResult = testSuiteResult.testCaseResult(MultiTestMethodTestCase.class);
        TestCaseResult borkenTestResult = testSuiteResult.testCaseResult(BrokenTestCase.class);
        assertEquals(new MultiTestMethodTestCase().run(), multiMethodTestResult);
        assertEquals(new BrokenTestCase().run(), borkenTestResult);
    }

    public static void main(String[] args) throws Throwable {
        new TestSuiteTest().run().reportAnyFailed();
    }
}
