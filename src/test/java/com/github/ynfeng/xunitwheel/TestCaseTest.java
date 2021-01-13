package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TestCaseTest extends TestCase {
    public TestCaseTest() {
        registerTestMethod("should_run_multiple_test_method", this::should_run_multiple_test_method);
        registerTestMethod("should_run_test_method", this::should_run_test_method);
        registerTestMethod("should_return_test_result", this::should_return_method_results);
        registerTestMethod("should_return_falied_method_result", this::should_return_failed_method_result);
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

    public void should_return_method_results() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();

        TestResult testResult = testCase.run();
        List<MethodResult> methodResults = testResult.methodResults();

        assertEquals(methodResults.get(0).methodName(), "method1");
        assertEquals(methodResults.get(0).isSuccess(), true);
        assertEquals(methodResults.get(1).methodName(), "method2");
        assertEquals(methodResults.get(1).isSuccess(), true);
    }

    public void should_return_failed_method_result() {
        BrokenTestCase testCase = new BrokenTestCase();

        TestResult testResult = testCase.run();
        List<MethodResult> methodResults = testResult.methodResults();

        assertEquals(methodResults.get(0).methodName(), "brokenMethod");
        assertEquals(methodResults.get(0).isSuccess(), false);
        assertEquals(methodResults.get(0).failedCause().getClass(), RuntimeException.class);
    }

    public static void main(String[] args) throws Throwable {
        new TestCaseTest().run().reportAnyFailed();
    }
}
