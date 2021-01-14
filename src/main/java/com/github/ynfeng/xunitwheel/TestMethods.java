package com.github.ynfeng.xunitwheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethods {
    private final List<TestMethod> methods = new ArrayList<>();

    public void add(TestMethod testMethod) {
        methods.add(testMethod);
    }

    public void run(TestCaseResult testCaseResult, Runnable setup, Runnable tearDown) {
        methods.forEach(method -> {
            try {
                invokeTestMethod(setup, method, tearDown);
                testCaseResult.addMethodResult(MethodResult.success(method.name()));
            } catch (Throwable t) {
                testCaseResult.addMethodResult(MethodResult.failed(method.name(), t));
            }
        });
    }

    private static void invokeTestMethod(Runnable setup, TestMethod method, Runnable tearDown) {
        setup.run();
        method.run();
        tearDown.run();
    }

    public int size() {
        return methods.size();
    }

    public List<String> methodNames() {
        return methods.stream().map(TestMethod::name).collect(Collectors.toList());
    }
}
