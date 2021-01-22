package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.annotation.Test;

public class TestSuiteTest {

    @Test
    public void should_register_test_cases() {
        TestSuite testSuite = new TestSuite();
        testSuite.registerTestCase(new MultiTestMethodTestCase());
        testSuite.registerTestCase(new SingleTestMethodTestCase());

        assertThat(testSuite.numOfTestCase(), isEquals(2));
    }

    @Test
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
}
