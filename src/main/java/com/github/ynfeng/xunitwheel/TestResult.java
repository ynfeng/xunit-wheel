package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestResult {
    private final List<MethodResult> methodResults = new ArrayList<>();

    protected void addMethodResult(MethodResult methodResult) {
        methodResults.add(methodResult);
    }

    public List<MethodResult> methodResults() {
        return Collections.unmodifiableList(methodResults);
    }

    public void reportAnyFailed() throws Throwable {
        Throwable anyFailed = methodResults.stream()
            .filter(each -> each.failedCause() != null)
            .findAny()
            .map(MethodResult::failedCause)
            .orElse(null);
        if (anyFailed != null) {
            throw anyFailed;
        }
    }
}
