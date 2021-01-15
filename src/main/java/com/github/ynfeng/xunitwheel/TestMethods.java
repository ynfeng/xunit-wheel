package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethods {
    private final List<TestMethod> methods = new ArrayList<>();
    private final TestCase testCase;

    public TestMethods(TestCase testCase) {
        this.testCase = testCase;
    }

    public void add(TestMethod testMethod) {
        methods.add(testMethod);
    }

    public void run() {
        methods.forEach(method -> testCase.addMethodResult(method.run()));
    }

    public int size() {
        return methods.size();
    }

    public List<String> methodNames() {
        return methods.stream().map(TestMethod::name).collect(Collectors.toList());
    }
}
