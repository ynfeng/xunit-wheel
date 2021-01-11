package com.github.ynfeng.xunitwheel;

public class TestCaseTest {

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
        new TestCaseTest().should_run_one_test_method();
        new TestCaseTest().should_run_multi_test_method();
    }
}
