package com.github.ynfeng.xunitwheel;

import com.github.ynfeng.xunitwheel.utils.AnnotationTestCaseClassScanner;
import java.util.List;

public class AnnotationTestSuite extends TestSuite {
    private final AnnotationTestCaseClassScanner scanner = new AnnotationTestCaseClassScanner();

    public AnnotationTestSuite() {
        this("");
    }

    public AnnotationTestSuite(String basePackage) {
        List<Class<?>> testClasses = scanner.scan(basePackage);
        testClasses.stream().map(AnnotationTestCase::new).forEach(this::registerTestCase);
    }

}
