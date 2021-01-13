package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TestCaseResult {
    private final List<MethodResult> methodResults = new ArrayList<>();

    protected void addMethodResult(MethodResult methodResult) {
        methodResults.add(methodResult);
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

    @Override
    public int hashCode() {
        return Objects.hash(methodResults);
    }
}
