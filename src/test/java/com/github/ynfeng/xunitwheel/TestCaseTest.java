package com.github.ynfeng.xunitwheel;

public class TestCaseTest extends TestCase {

    public void should_run_one_test_method() {
        OneTestMethodTestCase testCase = new OneTestMethodTestCase();
        testCase.registerTestMethod(testCase::method1);

        testCase.run();

        if (!"method1".equals(testCase.methodRunLog)) {
            throw new RuntimeException("method not run.");
        }
    }

    public void should_run_multi_test_method() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();
        testCase.registerTestMethod(testCase::method1);
        testCase.registerTestMethod(testCase::method2);

        testCase.run();

        if (!"method1 method2".equals(testCase.methodRunLog)) {
            throw new RuntimeException("some method not run.");
        }
    }

    public static void main(String[] args) {
        TestCaseTest testCase = new TestCaseTest();
        testCase.registerTestMethod(testCase::should_run_multi_test_method);
        testCase.registerTestMethod(testCase::should_run_one_test_method);
        testCase.run();
    }
}
