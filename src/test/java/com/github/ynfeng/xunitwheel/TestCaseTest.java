package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TestCaseTest extends TestCase {
    public TestCaseTest() {
        registerTestMethod("should_run_multiple_test_method", this::should_run_multiple_test_method);
        registerTestMethod("should_run_test_method", this::should_run_test_method);
        registerTestMethod("should_return_method_results", this::should_return_method_results);
        registerTestMethod("should_return_failed_method_result", this::should_return_failed_method_result);
        registerTestMethod("should_execute_setup_method_before_each_test_method", this::should_execute_setup_method_before_each_test_method);
        registerTestMethod("test_method_should_failed_when_setup_method_broken", this::test_method_should_failed_when_setup_method_broken);
        registerTestMethod("should_execute_tear_down_method_after_each_test_method", this::should_execute_tear_down_method_after_each_test_method);
        registerTestMethod("test_method_should_failed_when_tear_down_method_broken", this::test_method_should_failed_when_tear_down_method_broken);
    }

    public void should_run_test_method() {
        SingleTestMethodTestCase testCase = new SingleTestMethodTestCase();

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

        TestCaseResult testCaseResult = testCase.run();
        List<MethodResult> methodResults = testCaseResult.methodResults();

        assertEquals(methodResults.get(0).methodName(), "method1");
        assertEquals(methodResults.get(0).isSuccess(), true);
        assertEquals(methodResults.get(1).methodName(), "method2");
        assertEquals(methodResults.get(1).isSuccess(), true);
    }

    public void should_return_failed_method_result() {
        BrokenTestCase testCase = new BrokenTestCase();

        TestCaseResult testCaseResult = testCase.run();
        List<MethodResult> methodResults = testCaseResult.methodResults();

        assertEquals(methodResults.get(0).methodName(), "brokenMethod");
        assertEquals(methodResults.get(0).isSuccess(), false);
        assertEquals(methodResults.get(0).failedCause().getClass(), RuntimeException.class);
    }

    public void should_execute_setup_method_before_each_test_method() {
        SetupTestCase testCase = new SetupTestCase();
        TestCaseResult testResult = testCase.run();

        assertEquals(" setup method1 setup method2", testCase.methodLog);
        assertEquals(true, testResult.methodResults().get(0).isSuccess());
        assertEquals(true, testResult.methodResults().get(1).isSuccess());
    }

    public void test_method_should_failed_when_setup_method_broken() {
        BrokenSetupTestCase testCase = new BrokenSetupTestCase();

        TestCaseResult testResult = testCase.run();
        assertEquals(" setup setup", testCase.methodLog);
        assertEquals(2, testResult.numOfTestMethod());
        assertEquals(false, testResult.methodResults().get(0).isSuccess());
        assertEquals(false, testResult.methodResults().get(1).isSuccess());
    }

    public void should_execute_tear_down_method_after_each_test_method() {
        TearDownTestCase testCase = new TearDownTestCase();
        TestCaseResult testResult = testCase.run();

        assertEquals(" setup method1 teardown setup method2 teardown", testCase.methodLog);
        assertEquals(true, testResult.methodResults().get(0).isSuccess());
        assertEquals(true, testResult.methodResults().get(1).isSuccess());
    }

    public void test_method_should_failed_when_tear_down_method_broken() {
        BrokenTearDownTestCase testCase = new BrokenTearDownTestCase();

        TestCaseResult testResult = testCase.run();
        assertEquals(" setup method1 teardown setup method2 teardown", testCase.methodLog);
        assertEquals(2, testResult.numOfTestMethod());
        assertEquals(false, testResult.methodResults().get(0).isSuccess());
        assertEquals(false, testResult.methodResults().get(1).isSuccess());
    }

    public static void main(String[] args) throws Throwable {
        new TestCaseTest().run().reportAnyFailed();
    }
}
