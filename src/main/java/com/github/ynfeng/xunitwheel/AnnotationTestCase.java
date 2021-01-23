package com.github.ynfeng.xunitwheel;

import com.github.ynfeng.xunitwheel.annotation.Setup;
import com.github.ynfeng.xunitwheel.annotation.Teardown;
import com.github.ynfeng.xunitwheel.annotation.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class AnnotationTestCase extends TestCase {
    private final Class<?> testClass;
    private final Object testCaseInstance;

    public AnnotationTestCase(Class<?> testCls) {
        testClass = testCls;
        testCaseInstance = instanceTestCase();
        registerAnnotationMethods();
    }

    @Override
    public void setup() {
        findSetupMethod()
            .ifPresent(method -> invokeTestClassMethod(method));
    }

    @Override
    public void tearDown() {
        findTeardownMethod()
            .ifPresent(method -> invokeTestClassMethod(method));
    }

    private Optional<Method> findTeardownMethod() {
        return Arrays.stream(testClass.getMethods())
            .filter(method -> method.isAnnotationPresent(Teardown.class))
            .findAny();
    }

    private void invokeTestClassMethod(Method method) {
        try {
            method.invoke(testCaseInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<Method> findSetupMethod() {
        return Arrays.stream(testClass.getMethods())
            .filter(method -> method.isAnnotationPresent(Setup.class))
            .findAny();
    }

    private void registerAnnotationMethods() {
        Arrays.stream(testClass.getMethods())
            .filter(method -> method.isAnnotationPresent(Test.class))
            .forEach(testMethod -> registerAnnotationTestMethod(testMethod));
    }

    private void registerAnnotationTestMethod(Method testMethod) {
        registerTestMethod(testMethod.getName(), () -> invokeTestClassMethod(testMethod));
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
