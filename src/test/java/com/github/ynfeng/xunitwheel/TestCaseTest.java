package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

import java.util.Arrays;

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

        assertEquals(testCase.numOfTestMethod(), 2);
        assertEquals(testCase.testMethodNames(), Arrays.asList("method1", "method2"));
        assertEquals("method1 method2", testCase.methodRunLog);
    }

    public static void main(String[] args) {
        TestCaseTest testCase = new TestCaseTest();
        testCase.registerTestMethod("should_run_multiple_test_method", testCase::should_run_multiple_test_method);
        testCase.registerTestMethod("should_run_test_method", testCase::should_run_test_method);
        testCase.run();
    }
}
