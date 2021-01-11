package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

public class TestCaseTest extends TestCase {

    public void should_run_test_method() {
        OneTestMethodTestCase testCase = new OneTestMethodTestCase();
        testCase.registerTestMethod("method1", testCase::method1);

        testCase.run();

        assertEquals("method1", testCase.methodRunLog);
    }

    public void should_run_multiple_test_method() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();
        testCase.registerTestMethod("method1", testCase::method1);
        testCase.registerTestMethod("method2", testCase::method2);

        testCase.run();

        assertEquals("method1 method2", testCase.methodRunLog);
    }

    public static void main(String[] args) {
        TestCaseTest testCase = new TestCaseTest();
        testCase.registerTestMethod("should_run_multiple_test_method", testCase::should_run_multiple_test_method);
        testCase.registerTestMethod("should_run_test_method", testCase::should_run_test_method);
        testCase.run();
    }
}
