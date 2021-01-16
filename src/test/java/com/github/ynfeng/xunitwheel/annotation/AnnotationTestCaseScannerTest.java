package com.github.ynfeng.xunitwheel.annotation;

import static com.github.ynfeng.xunitwheel.Assertions.assertEquals;

import com.github.ynfeng.xunitwheel.TestCase;
import com.github.ynfeng.xunitwheel.utils.AnnotationTestCaseClassScanner;
import java.util.List;

public class AnnotationTestCaseScannerTest extends TestCase {

    public AnnotationTestCaseScannerTest() {
        registerTestMethod("should_scan_annotated_test_case", this::should_scan_annotated_test_case);
    }

    public void should_scan_annotated_test_case() {
        AnnotationTestCaseClassScanner scanner = new AnnotationTestCaseClassScanner();

        List<Class<?>> testCases = scanner.scan("com.github.ynfeng.xunitwheel");

        assertEquals(AnnotationTest.class, testCases.get(0));
    }

    public static void main(String[] args) throws Throwable {
        new AnnotationTestCaseScannerTest().run().reportAnyFailed();
    }
}
