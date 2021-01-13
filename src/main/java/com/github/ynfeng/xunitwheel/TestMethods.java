package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethods {
    private final List<TestMethod> methods = new ArrayList<>();

    public void add(TestMethod testMethod) {
        methods.add(testMethod);
    }

    public TestCaseResult run() {
        TestCaseResult testCaseResult = new TestCaseResult();
        methods.forEach(method -> {
            try {
                method.run();
                testCaseResult.addMethodResult(MethodResult.success(method.name()));
            } catch (Throwable t) {
                testCaseResult.addMethodResult(MethodResult.failed(method.name(), t));
            }
        });
        return testCaseResult;
    }

    public int size() {
        return methods.size();
    }

    public List<String> methodNames() {
        return methods.stream().map(TestMethod::name).collect(Collectors.toList());
    }
}
