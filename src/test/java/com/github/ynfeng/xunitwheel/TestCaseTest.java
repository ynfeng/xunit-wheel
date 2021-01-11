package com.github.ynfeng.xunitwheel;

public class TestCaseTest {

    public void should_run_test_method() {
        TestMethods testMethods = new TestMethods();

        testMethods.run();

        if (!"method1".equals(testMethods.methodRunLog)) {
            throw new RuntimeException("method not run.");
        }
    }

//    public void should_run_multi_test_method() {
//        TestMethods testMethods = new TestMethods();
//
//        testMethods.run();
//
//        if (!testMethods.methodRun) {
//            throw new RuntimeException("method not run.");
//        }
//    }

    public static void main(String[] args) {
        new TestCaseTest().should_run_test_method();
    }
}
