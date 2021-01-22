package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.annotation.AnnotationTest;
import com.github.ynfeng.xunitwheel.annotation.Test;

class AnnotationTestSuiteTest {

    @Test
    public void should_get_test_case() {
        AnnotationTestSuite testSuite = new AnnotationTestSuite("com.github.ynfeng.xunitwheel.annotation");

        assertThat(testSuite.numOfTestCase(), isEquals(2));
    }

    @Test
    public void should_run_test_case() {
        AnnotationTestSuite testSuite = new AnnotationTestSuite("com.github.ynfeng.xunitwheel.annotation");

        TestSuiteResult result = testSuite.run();

        MethodResult testMethodResult = result.testCaseResult(AnnotationTest.class).methodResults().get(0);
        assertThat(testMethodResult.methodName(), isEquals("empty_test"));
        assertThat(testMethodResult.isSuccess(), isEquals(true));
    }
}
