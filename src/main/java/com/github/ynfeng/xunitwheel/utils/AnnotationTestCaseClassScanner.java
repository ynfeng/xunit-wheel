package com.github.ynfeng.xunitwheel.utils;

import com.github.ynfeng.xunitwheel.annotation.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotationTestCaseClassScanner {
    private final ClassScanner classScanner = new ClassScanner();

    public List<Class<?>> scan(String basePackage) {
        return classScanner.scan(basePackage)
            .stream()
            .filter(AnnotationTestCaseClassScanner::hasAnnotatedMethod)
            .collect(Collectors.toList());
    }

    private static boolean hasAnnotatedMethod(Class<?> cls) {
        return Arrays.stream(cls.getMethods()).anyMatch(each -> each.isAnnotationPresent(Test.class));
    }
}
