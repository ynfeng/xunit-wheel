package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethods {
    private final List<TestMethod> methods = new ArrayList<>();

    public void add(TestMethod testMethod) {
        methods.add(testMethod);
    }

    public TestResult run() {
        TestResult testResult = new TestResult();
        methods.forEach(method -> {
            try {
                method.run();
                testResult.addMethodResult(MethodResult.success(method.name()));
            } catch (Throwable t) {
                testResult.addMethodResult(MethodResult.failed(method.name(), t));
            }
        });
        return testResult;
    }

    public int size() {
        return methods.size();
    }

    public List<String> methodNames() {
        return methods.stream().map(TestMethod::name).collect(Collectors.toList());
    }
}
