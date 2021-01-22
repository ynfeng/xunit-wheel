package com.github.ynfeng.xunitwheel;

import com.github.ynfeng.xunitwheel.annotation.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTestCase extends TestCase {
    private final Class<?> testClass;

    public AnnotationTestCase(Class<?> testCls) {
        testClass = testCls;
        Object testCaseInstance = instanceTestCase();
        registerAnnotationMethods(testCaseInstance);
    }

    private void registerAnnotationMethods(Object testCaseInstance) {
        Arrays.stream(testClass.getMethods())
            .filter(method -> method.isAnnotationPresent(Test.class))
            .forEach(testMethod -> registerAnnotationTestMethod(testCaseInstance, testMethod));
    }

    private void registerAnnotationTestMethod(Object testCaseInstance, Method testMethod) {
        registerTestMethod(testMethod.getName(), () -> {
            try {
                testMethod.invoke(testCaseInstance);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Object instanceTestCase() {
        try {
            return testClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String testCaseName() {
        return testClass.getName();
    }

    @Override
    protected Class<?> testClass() {
        return testClass;
    }
}
