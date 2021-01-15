package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethods {
    private final List<TestMethod> methods = new ArrayList<>();

    public void add(TestMethod testMethod) {
        methods.add(testMethod);
    }

    public void run(TestCaseResult testCaseResult) {
        methods.forEach(method -> testCaseResult.addMethodResult(method.run()));
    }

    public int size() {
        return methods.size();
    }

    public List<String> methodNames() {
        return methods.stream().map(TestMethod::name).collect(Collectors.toList());
    }
}
