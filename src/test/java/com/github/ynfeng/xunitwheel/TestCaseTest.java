package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

public class TestCaseTest extends TestCase {

    public void should_run_test_method() {
        OneTestMethodTestCase testCase = new OneTestMethodTestCase();
        testCase.registerTestMethod(testCase::method1);

        testCase.run();

        assertEquals("method1", testCase.methodRunLog);
    }

    public void should_run_multi_test_method() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();
        testCase.registerTestMethod(testCase::method1);
        testCase.registerTestMethod(testCase::method2);

        testCase.run();

        assertEquals("method1 method2", testCase.methodRunLog);
    }

    public static void main(String[] args) {
        TestCaseTest testCase = new TestCaseTest();
        testCase.registerTestMethod(testCase::should_run_multi_test_method);
        testCase.registerTestMethod(testCase::should_run_test_method);
        testCase.run();
    }
}
