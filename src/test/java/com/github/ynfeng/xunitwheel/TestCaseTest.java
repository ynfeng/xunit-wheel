package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

import java.util.Arrays;

public class TestCaseTest extends TestCase {
    public TestCaseTest() {
        registerTestMethod("should_run_multiple_test_method", this::should_run_multiple_test_method);
        registerTestMethod("should_run_test_method", this::should_run_test_method);
    }

    public void should_run_test_method() {
        OneTestMethodTestCase testCase = new OneTestMethodTestCase();

        testCase.run();

        assertEquals("method1", testCase.methodRunLog);
    }

    public void should_run_multiple_test_method() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();

        testCase.run();

        assertEquals(testCase.numOfTestMethod(), 2);
        assertEquals(testCase.testMethodNames(), Arrays.asList("method1", "method2"));
        assertEquals("method1 method2", testCase.methodRunLog);
    }

    public static void main(String[] args) {
        new TestCaseTest().run();
    }
}
