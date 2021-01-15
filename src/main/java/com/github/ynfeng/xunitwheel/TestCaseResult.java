package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TestCaseResult {
    private final List<MethodResult> methodResults = new ArrayList<>();

    private TestCaseResult(List<MethodResult> methodResults) {
        this.methodResults.addAll(methodResults);
    }

    public static TestCaseResult create(List<MethodResult> methodResults) {
        return new TestCaseResult(methodResults);
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

    public int numOfTestMethod() {
        return methodResults.size();
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
}
