package com.github.ynfeng.xunitwheel.annotation;

import static com.github.ynfeng.xunitwheel.assertion.Assertions.assertThat;
import static com.github.ynfeng.xunitwheel.assertion.Assertions.isEquals;

import com.github.ynfeng.xunitwheel.utils.AnnotationTestCaseClassScanner;
import com.github.ynfeng.xunitwheel.utils.ClassScannerTest;
import java.util.List;

public class AnnotationTestCaseScannerTest {

    @Test
    public void should_scan_annotated_test_case() {
        AnnotationTestCaseClassScanner scanner = new AnnotationTestCaseClassScanner();

        List<Class<?>> testCases = scanner.scan("com.github.ynfeng.xunitwheel.utils");

        assertThat(testCases.get(0), isEquals(ClassScannerTest.class));
    }
}
