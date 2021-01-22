package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

public class TestSuiteTest extends TestCase {
    public TestSuiteTest() {
        registerTestMethod("should_create_test_suite", this::should_register_test_cases);
        registerTestMethod("should_run_test_suite", this::should_run_test_suite);
    }

    public void should_register_test_cases() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new SingleTestMethodTestCase());

        assertThat(testSuite.numOfTestCase(), isEquals(2));
    }

    public void should_run_test_suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new BrokenTestCase());

        TestSuiteResult testSuiteResult = testSuite.run();

        assertThat(testSuiteResult.numOfTestCaseResult(), isEquals(2));

        TestCaseResult multiMethodTestResult = testSuiteResult.testCaseResult(MultiTestMethodTestCase.class);
        TestCaseResult borkenTestResult = testSuiteResult.testCaseResult(BrokenTestCase.class);
        assertThat(new MultiTestMethodTestCase().run(), isEquals(multiMethodTestResult));
        assertThat(new BrokenTestCase().run(), isEquals(borkenTestResult));
    }

    public static void main(String[] args) throws Throwable {
        new TestSuiteTest().run().reportAnyFailed();
    }
}
