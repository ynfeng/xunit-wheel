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

        assertEquals(testSuite.numOfTestCase(), 2);
    }

    public void should_run_test_suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new BrokenTestCase());

        TestSuiteResult testSuiteResult = testSuite.run();

        assertEquals(testSuiteResult.numOfTestCaseResult(), 2);

        TestCaseResult multiMethodTestResult = testSuiteResult.testCaseResult(MultiTestMethodTestCase.class);
        TestCaseResult borkenTestResult = testSuiteResult.testCaseResult(BrokenTestCase.class);
        assertEquals(multiMethodTestResult, new MultiTestMethodTestCase().run());
        assertEquals(borkenTestResult, new BrokenTestCase().run());
    }

    public static void main(String[] args) throws Throwable {
        new TestSuiteTest().run().reportAnyFailed();
    }
}
