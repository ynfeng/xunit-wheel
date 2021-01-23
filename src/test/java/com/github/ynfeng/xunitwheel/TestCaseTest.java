package com.github.ynfeng.xunitwheel;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.annotation.Test;
import com.github.ynfeng.xunitwheel.fixture.BrokenSetupTestCase;
import com.github.ynfeng.xunitwheel.fixture.BrokenTearDownTestCase;
import com.github.ynfeng.xunitwheel.fixture.BrokenTestCase;
import com.github.ynfeng.xunitwheel.fixture.MultiTestMethodTestCase;
import com.github.ynfeng.xunitwheel.fixture.SetupTestCase;
import com.github.ynfeng.xunitwheel.fixture.SingleTestMethodTestCase;
import com.github.ynfeng.xunitwheel.fixture.TearDownTestCase;
import java.util.Arrays;
import java.util.List;

public class TestCaseTest {

    @Test
    public void should_run_test_method() {
        SingleTestMethodTestCase testCase = new SingleTestMethodTestCase();

        testCase.run();

        assertThat(testCase.methodRunLog, isEquals("method1"));
    }

    @Test
    public void should_run_multiple_test_method() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();

        testCase.run();

        assertThat(testCase.numOfTestMethod(), isEquals(2));
        assertThat(testCase.testMethodNames(), isEquals(Arrays.asList("method1", "method2")));
        assertThat(testCase.methodRunLog, isEquals("method1 method2"));
    }

    @Test
    public void should_return_method_results() {
        MultiTestMethodTestCase testCase = new MultiTestMethodTestCase();

        TestCaseResult testCaseResult = testCase.run();
        List<MethodResult> methodResults = testCaseResult.methodResults();

        assertThat(methodResults.get(0).methodName(), isEquals("method1"));
        assertThat(methodResults.get(0).isSuccess(), isEquals(true));
        assertThat(methodResults.get(1).methodName(), isEquals("method2"));
        assertThat(methodResults.get(1).isSuccess(), isEquals(true));
    }

    @Test
    public void should_return_failed_method_result() {
        BrokenTestCase testCase = new BrokenTestCase();

        TestCaseResult testCaseResult = testCase.run();
        List<MethodResult> methodResults = testCaseResult.methodResults();

        assertThat(methodResults.get(0).methodName(), isEquals("brokenMethod"));
        assertThat(methodResults.get(0).isSuccess(), isEquals(false));
        assertThat(methodResults.get(0).failedCause().getClass(), isEquals(RuntimeException.class));
    }

    @Test
    public void should_execute_setup_method_before_each_test_method() {
        SetupTestCase testCase = new SetupTestCase();
        TestCaseResult testResult = testCase.run();

        assertThat(testCase.methodLog, isEquals(" setup method1 setup method2"));
        assertThat(testResult.methodResults().get(0).isSuccess(), isEquals(true));
        assertThat(testResult.methodResults().get(0).isSuccess(), isEquals(true));
    }

    @Test
    public void test_method_should_failed_when_setup_method_broken() {
        BrokenSetupTestCase testCase = new BrokenSetupTestCase();

        TestCaseResult testResult = testCase.run();
        assertThat(testCase.methodLog, isEquals(" setup setup"));
        assertThat(testResult.numOfTestMethod(), isEquals(2));
        assertThat(testResult.methodResults().get(0).isSuccess(), isEquals(false));
        assertThat(testResult.methodResults().get(1).isSuccess(), isEquals(false));
    }

    @Test
    public void should_execute_tear_down_method_after_each_test_method() {
        TearDownTestCase testCase = new TearDownTestCase();
        TestCaseResult testResult = testCase.run();

        assertThat(testCase.methodLog, isEquals(" setup method1 teardown setup method2 teardown"));
        assertThat(testResult.methodResults().get(0).isSuccess(), isEquals(true));
        assertThat(testResult.methodResults().get(1).isSuccess(), isEquals(true));
    }

    @Test
    public void test_method_should_not_failed_when_tear_down_method_broken() {
        BrokenTearDownTestCase testCase = new BrokenTearDownTestCase();

        TestCaseResult testResult = null;
        try {
            testResult = testCase.run();
        } catch (RuntimeException ignored) {
        }

        assertThat(testCase.methodLog, isEquals(" setup method1 teardown setup method2 teardown"));
        assertThat(testResult.numOfTestMethod(), isEquals(2));
        assertThat(testResult.methodResults().get(0).isSuccess(), isEquals(true));
        assertThat(testResult.methodResults().get(1).isSuccess(), isEquals(true));
    }
}
