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
}
