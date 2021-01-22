package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.annotation.AnnotationTest;

class AnnotationTestSuiteTest extends TestCase {
    public AnnotationTestSuiteTest() {
        registerTestMethod("should_get_test_case", this::should_get_test_case);
        registerTestMethod("should_run_test_case", this::should_run_test_case);
    }

    public void should_get_test_case() {
        AnnotationTestSuite testSuite = new AnnotationTestSuite("com.github.ynfeng.xunitwheel.annotation");

        assertThat(testSuite.numOfTestCase(), isEquals(1));
    }

    public void should_run_test_case() {
        AnnotationTestSuite testSuite = new AnnotationTestSuite("com.github.ynfeng.xunitwheel.annotation");

        TestSuiteResult result = testSuite.run();

        MethodResult testMethodResult = result.testCaseResult(AnnotationTest.class).methodResults().get(0);
        assertThat(testMethodResult.methodName(), isEquals("empty_test"));
        assertThat(testMethodResult.isSuccess(), isEquals(true));
    }

    public static void main(String[] args) throws Throwable {
        new AnnotationTestSuiteTest().run().reportAnyFailed();
    }
}
