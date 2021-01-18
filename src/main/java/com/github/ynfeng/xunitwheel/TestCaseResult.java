package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TestCaseResult {
    private final List<MethodResult> methodResults = new ArrayList<>();
    private final String testCaseName;

    private TestCaseResult(String testCaseName, List<MethodResult> methodResults) {
        this.testCaseName = testCaseName;
        this.methodResults.addAll(methodResults);
    }

    public static TestCaseResult create(String testCaseName, List<MethodResult> methodResults) {
        return new TestCaseResult(testCaseName, methodResults);
    }

    public List<MethodResult> methodResults() {
        return Collections.unmodifiableList(methodResults);
    }

    public void reportAnyFailed() throws Throwable {
        Throwable anyFailed = findAnyFailed();
        if (anyFailed != null) {
            throw anyFailed;
        }
    }

    private Throwable findAnyFailed() {
        return methodResults.stream()
            .filter(each -> each.failedCause() != null)
            .findAny()
            .map(MethodResult::failedCause)
            .orElse(null);
    }

    public String testCaseName() {
        return testCaseName;
    }

    public int numOfTestMethod() {
        return methodResults.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TestCaseResult)) {
            return false;
        }
        TestCaseResult that = (TestCaseResult) o;
        return methodResults.equals(that.methodResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodResults);
    }

    @Override
    public String toString() {
        return "TestCaseResult{" +
            "methodResults=" + methodResults +
            '}';
    }

    public int numOfFailedMethod() {
        return (int) methodResults.stream().filter(each -> !each.isSuccess()).count();
    }
}
